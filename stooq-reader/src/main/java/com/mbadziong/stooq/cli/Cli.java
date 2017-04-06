package com.mbadziong.stooq.cli;


import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cli {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cli.class);

    private String[] args;
    private Options options;

    public Cli(String[] args) {
        this.args = args;
        options = initializeDefaultOptions();
    }

    public int parseArgs() {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);

            if(cmd.hasOption("i")) {
                String interval = cmd.getOptionValue("i");
                LOGGER.info("Parsed %d as interval", interval);
            }

        } catch (ParseException e) {
            LOGGER.error("Parse error", e);
            showHelp();
        }

        return 60;
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
