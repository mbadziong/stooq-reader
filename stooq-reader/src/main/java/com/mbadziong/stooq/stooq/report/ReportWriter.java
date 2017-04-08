package com.mbadziong.stooq.stooq.report;

import com.mbadziong.stooq.stooq.httpclient.model.MarketIndex;
import com.mbadziong.stooq.stooq.report.model.ReportRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

@Component
public class ReportWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportWriter.class);

    @Value("${report_path}")
    private String reportPath;

    public void writeToFile(MarketIndex marketIndex) {
        ReportRow row = new ReportRow(marketIndex);
        List<String> lines = Arrays.asList(row.toString());
        try {
            Files.write(
                    Paths.get(reportPath),
                    lines,
                    Charset.defaultCharset(),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE
            );
        } catch (IOException e) {
            LOGGER.error("Error while appending new row to file.", e.getMessage());
        }
    }
}
