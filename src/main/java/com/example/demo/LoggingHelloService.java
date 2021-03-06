package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingHelloService implements HelloService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String greeting;
	
/*	public LoggingHelloService(@Value("${hello.greeting:Hello}")String greeting) {
		super();
		this.greeting = greeting;
	}*/
	
	public LoggingHelloService(HelloProperties helloProperties) {
	    String greeting = helloProperties.getGreeting();
	    if (greeting == null) {
	      greeting = "Hello";
	    }
	    this.greeting = greeting;
	  }
	
	@Override
	public void greet() {
		logger.info("{} World.", greeting);

	}

}
