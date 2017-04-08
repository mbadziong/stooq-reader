package com.mbadziong.stooq.stooq.httpclient.parser;

import com.mbadziong.stooq.stooq.httpclient.exception.CsvFormatException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class StooqCsvParser {

    private static final String MARKET_INDEX_VALUE_COLUMN = "Zamkniecie";
    private static final int STOOQ_CSV_RESPONSE_ROWS = 2;
    private static final String STOOQ_CSV_EOL = "\r\n";
    private static final String STOOQ_CSV_DELIMITER = ",";

    public BigDecimal getMarketIndexValue(String csv) throws CsvFormatException {
        Map<String, String> stooqMap = parseCsv(csv);

        return new BigDecimal(stooqMap.get(MARKET_INDEX_VALUE_COLUMN));
    }

    public Map<String, String> parseCsv(String csv) throws CsvFormatException {
        String[] csvRows = csv.split(STOOQ_CSV_EOL);

        HashMap<String, String> stooqMap = new HashMap<>();

        String[] columnNames = csvRows[0].split(STOOQ_CSV_DELIMITER);
        String[] columnValues = csvRows[1].split(STOOQ_CSV_DELIMITER);

        if (csvRows.length != STOOQ_CSV_RESPONSE_ROWS ||
                columnNames.length != columnValues.length) {
            throw new CsvFormatException("Not valid stooq csv response.");
        }

        for (int columnNum = 0; columnNum < columnNames.length; columnNum++) {
            stooqMap.put(columnNames[columnNum], columnValues[columnNum]);
        }

        return stooqMap;
    }
}
