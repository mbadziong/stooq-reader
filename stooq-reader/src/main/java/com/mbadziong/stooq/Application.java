package com.mbadziong.stooq;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws SchedulerException {
        SpringApplication springApplication = new SpringApplication();
        ApplicationContext ctx = springApplication.run(Application.class, args);
    }
}
