package com.mbadziong.stooq.stooq.report;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import com.mbadziong.stooq.stooq.report.model.ReportRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ReportWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportWriter.class);

    @Value("${report_path}")
    private String reportPath;

    private Gson gson;

    public ReportWriter(Gson gson) {
        this.gson = gson;
    }

    public void writeToFile(MarketIndex marketIndex) {
        ReportRow row = new ReportRow(marketIndex);
        List<ReportRow> currentRows = getCurrentReport();
        currentRows.add(row);
        List<String> lines = Arrays.asList(gson.toJson(currentRows));

        try {
            Files.write(
                    Paths.get(reportPath),
                    lines,
                    Charset.defaultCharset(),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE
            );
        } catch (IOException e) {
            LOGGER.error("Error while appending new row to file.", e.getMessage());
        }
    }

    private List<ReportRow> getCurrentReport() {
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(Paths.get(reportPath));
        } catch (IOException e) {
            LOGGER.error("Error while reading file.");
        }

        String json = String.join("", content);
        Type listType = new TypeToken<ArrayList<ReportRow>>() {
        }.getType();
        List<ReportRow> currentRows = gson.fromJson(json, listType);

        if (currentRows == null) {
            currentRows = new ArrayList<>();
        }

        return currentRows;
    }
}
