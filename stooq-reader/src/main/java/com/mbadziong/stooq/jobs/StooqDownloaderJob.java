package com.mbadziong.stooq.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class StooqDownloaderJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //TODO: download stooq data and persist
        System.out.println("stooq job");
    }
}
