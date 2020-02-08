package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Test1Application {
	
	private static final Logger logger = LogManager.getLogger(Test1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
		
		logger.debug("Rest controller executing");
		logger.debug("Debugging log in our greeting method");
		logger.info("Info log in our greeting method");
		logger.warn("Warning log in our greeting method");
		logger.error("Error in our greeting method");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
