package com.mbadziong.stooq.jobs;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class StooqDownloaderJobScheduler {

    private static final String STOOQ_JOB_NAME = "stooq_job";
    private static final String STOOQ_GROUP_NAME = "stooq_group";
    private static final String STOOQ_TRIGGER_NAME = "stooq_trigger";

    public void run(int intervalInSeconds) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail job = newJob(StooqDownloaderJob.class)
                .withIdentity(STOOQ_JOB_NAME, STOOQ_GROUP_NAME)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity(STOOQ_TRIGGER_NAME, STOOQ_GROUP_NAME)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(intervalInSeconds)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
