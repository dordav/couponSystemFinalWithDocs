package webServices;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this is the main class,
 * here the app get start by using the 
 * @author Dorda
 *
 */
@SpringBootApplication

public class FirstWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebServiceApplication.class, args);
		LoggerFactory.getLogger("LoggerService.class");

	}
}
