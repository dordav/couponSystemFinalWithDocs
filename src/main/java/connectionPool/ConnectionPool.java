package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;

import exceptions.CouponSystemException;
import webServices.LoggerService;
/**
 * the connectionPool have 10 connections , every method start with taking one connection
 * and finished with returning the connection .
 * its a singleton .
 *
 */
public class ConnectionPool {

	Logger logger = LoggerService.getLogger();
//	private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);
	private String url = "jdbc:derby:coupon;create=true";
	private Collection<Connection> connections;
	final static int con_min_size = 0;
	final static int con_max_size = 10;
	private int counter;
	
	public boolean closing;

	// singleton
	private ConnectionPool() throws CouponSystemException {
		connections = new HashSet<>();
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			for (int i = 0; i < con_max_size; i++) {
				Connection con = DriverManager.getConnection(url);
				connections.add(con);
			}
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("connection pool initalization error"+ e);
			throw new CouponSystemException("Something went wrong ", e);
		}
	}
	

	private static ConnectionPool instance;
/**
 * user cannot create a new connection pool . only use an instance of the only one .
 * @return
 * @throws CouponSystemException
 */
	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			instance = new ConnectionPool();
			
		}
		return instance;
	}

	/**
	 * all the methods use connection that they get from this method . 
	 * @return
	 * @throws CouponSystemException
	 */
	public synchronized Connection getConnection() throws CouponSystemException {
		if (closing == true) {
			throw new CouponSystemException("we are clousing the progrem");

		}
		if (connections.size() == con_min_size) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new CouponSystemException("we have an interruption in getting a connection",e);
			}
		}
		Iterator<Connection> it = connections.iterator();
		Connection con = (Connection) it.next();
		connections.remove(con);
		return con;

	}
/**
 * every method in the dbdao finished by returning the connection they took . 
 * @param con
 */
	public synchronized void returnConnection(Connection con) {
		connections.add(con);
		notify();
	}
/**
 * in this method first the system will stop giving connections and wait 
 * for all the  connections to come back and than close them all .
 * @throws CouponSystemException
 */
	public synchronized void closeAllConnection() throws CouponSystemException {
		closing = true;
		while (connections.size() < con_max_size) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new CouponSystemException("we were interrupted", e);
			}
		}
		while (!(counter == con_max_size)) {
			Iterator<Connection> it = connections.iterator();
			it.next();
			it.remove();
			counter++;
		}

	}

}
