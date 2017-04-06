package com.mbadziong.stooq;

import com.mbadziong.stooq.cli.Cli;
import com.mbadziong.stooq.jobs.StooqDownloaderJobScheduler;
import org.quartz.SchedulerException;

public class App
{
    public static void main( String[] args ) throws SchedulerException {
        int interval = new Cli(args).parseArgs();
        new StooqDownloaderJobScheduler().run(interval);
    }
}
