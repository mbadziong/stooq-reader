package com.mbadziong.stooq.cli;


import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cli {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cli.class);
    public static final int DEFAULT_INTERVAL_OPTION_VALUE = 60;

    private String[] args;
    private Options options;

    public Cli(String[] args) {
        this.args = args;
        options = initializeDefaultOptions();
    }

    public int parseInterval() {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        int interval = 0;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String optionValue = cmd.getOptionValue("i");
                LOGGER.info("interval value", optionValue);
                interval = Integer.parseInt(optionValue);
                LOGGER.info("Parsed %d as interval", interval);
            }

        } catch (ParseException | NumberFormatException e) {
            LOGGER.error("Parse error", e);
            showHelp();
        }

        return interval > 0
                ? interval
                : DEFAULT_INTERVAL_OPTION_VALUE;
    }

    private Options initializeDefaultOptions() {
        Options options = new Options();
        options.addOption("h", "help", false, "Shows help.");
        options.addOption("i", "interval", true, "Stooq data update interval in seconds.");

        return options;
    }

    private void showHelp() {
        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Stooq Reader", options);
    }
}
