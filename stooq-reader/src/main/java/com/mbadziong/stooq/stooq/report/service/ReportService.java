package com.mbadziong.stooq.stooq.report.service;

import com.mbadziong.stooq.stooq.httpclient.model.MarketIndex;
import com.mbadziong.stooq.stooq.report.ReportWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private ReportWriter reportWriter;

    private static MarketIndex latest;

    public void newValues(MarketIndex current) {
        if (current.equals(latest)) {
            LOGGER.info("Skipping append to file, current values are the same as latest.");
        } else {
            reportWriter.writeToFile(current);
            latest = current;
        }
    }
}
