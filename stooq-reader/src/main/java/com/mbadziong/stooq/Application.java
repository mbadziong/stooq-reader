package com.mbadziong.stooq;

import com.mbadziong.stooq.cli.Cli;
import com.mbadziong.stooq.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication springApplication = new SpringApplication();
        ApplicationContext ctx = springApplication.run(Application.class, args);
        JobDetailImpl job = (JobDetailImpl) ctx.getBean("stooqJob");

        new Scheduler().run(job, new Cli(args).parseInterval());
    }
}
