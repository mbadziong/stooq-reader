package com.mbadziong.stooq;

import com.mbadziong.stooq.jobs.StooqDownloaderJobScheduler;
import org.quartz.SchedulerException;

public class App
{
    public static void main( String[] args ) throws SchedulerException {
        StooqDownloaderJobScheduler scheduler = new StooqDownloaderJobScheduler();
        scheduler.run(5);
    }
}
