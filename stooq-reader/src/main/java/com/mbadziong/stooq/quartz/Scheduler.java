package com.mbadziong.stooq.quartz;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Scheduler {
    public void run(JobDetail job, int interval) throws SchedulerException {
        org.quartz.Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(interval)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
