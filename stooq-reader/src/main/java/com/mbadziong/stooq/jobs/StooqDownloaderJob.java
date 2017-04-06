package com.mbadziong.stooq.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StooqDownloaderJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(StooqDownloaderJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //TODO: download stooq data and persist
        LOGGER.info("running job");
        System.out.println("stooq job");
    }
}
