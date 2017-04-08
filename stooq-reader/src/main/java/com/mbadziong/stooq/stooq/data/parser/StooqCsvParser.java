package com.mbadziong.stooq.stooq.data.parser;

import com.mbadziong.stooq.stooq.exception.CsvFormatException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class StooqCsvParser {

    private static final String MARKET_INDEX_VALUE_COLUMN = "Zamkniecie";

    public BigDecimal getMarketIndexValue(String csv) throws CsvFormatException {
        Map<String, String> stooqMap = parseCsv(csv);

        return new BigDecimal(stooqMap.get(MARKET_INDEX_VALUE_COLUMN));
    }

    public Map<String, String> parseCsv(String csv) throws CsvFormatException {
        String[] csvRows = csv.split("\r\n");

        HashMap<String, String> stooqMap = new HashMap<>();

        String[] columnNames = csvRows[0].split(",");
        String[] columnValues = csvRows[1].split(",");

        if (csvRows.length != 2 || columnNames.length != columnValues.length) {
            throw new CsvFormatException("Not valid stooq csv response.");
        }

        for (int columnNum = 0; columnNum < columnNames.length; columnNum++) {
            stooqMap.put(columnNames[columnNum], columnValues[columnNum]);
        }

        return stooqMap;
    }
}
