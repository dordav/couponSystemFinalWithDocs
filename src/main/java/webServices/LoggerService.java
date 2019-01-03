package webServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class LoggerService {
 
	public static Logger getLogger() {
		return logger;
	}
	public static final Logger logger = LoggerFactory.getLogger(LoggerService.class);
	public LoggerService(){
	 logger.error("Test");
	 
 }
}
