package com.mbadziong.stooq.cli;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CliTest {

    @Test
    public void parseInterval_ReturnsPassedIntervalValue() {
        int passedInterval = 20;
        Cli cli = new Cli(new String[]{"-i", Integer.toString(passedInterval)});

        int interval = cli.parseInterval();

        assertEquals(passedInterval, interval);
    }

    @Test
    public void parseInterval_ReturnsDefaultIntervalValueWhenError() {
        Cli cli = new Cli(new String[]{"-i", "invalid value"});

        int interval = cli.parseInterval();

        assertEquals(Cli.DEFAULT_INTERVAL_OPTION_VALUE, interval);
    }

    @Test
    public void parseInterval_ReturnsDefaultIntervalValueWhenLessThanZero() {
        int passedInterval = -1;
        Cli cli = new Cli(new String[]{"-i", Integer.toString(passedInterval)});

        int interval = cli.parseInterval();

        assertEquals(Cli.DEFAULT_INTERVAL_OPTION_VALUE, interval);
    }

}
