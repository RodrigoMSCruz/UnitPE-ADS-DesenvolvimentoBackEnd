package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication 
public class SpringBootJournalAppApplication extends SpringBootServletInitializer { 
	public static void main(String[] args) throws Exception {
    	SpringApplication.run(SpringBootJournalAppApplication.class, args);
	}

}
