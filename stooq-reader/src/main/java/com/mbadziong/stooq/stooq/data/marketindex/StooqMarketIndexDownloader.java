package com.mbadziong.stooq.stooq.data.marketindex;


import com.mbadziong.stooq.stooq.data.exception.CsvFormatException;
import com.mbadziong.stooq.stooq.data.model.StooqMarketIndex;
import com.mbadziong.stooq.stooq.data.parser.StooqCsvParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public abstract class StooqMarketIndexDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(StooqMarketIndexDownloader.class);

    protected final static String STOOQ_URL = "https://stooq.pl/q/l/?s=%s&f=sd2t2ohlc&h&e=csv";

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private StooqCsvParser stooqCsvParser;

    protected StooqMarketIndex stooqMarketIndex;

    private BigDecimal latestValue;

    public BigDecimal getCurrentValue() {
        BigDecimal currentValue = latestValue;

        try {
            String response = restTemplate.getForObject(
                    String.format(STOOQ_URL, stooqMarketIndex.stockMarketIndex()),
                    String.class);

            currentValue = stooqCsvParser.getMarketIndexValue(response);
            latestValue = currentValue;
        } catch (CsvFormatException e) {
            LOGGER.error("Error during csv parse, returning latest value instead.", e);
        } catch (RestClientException e) {
            LOGGER.error("Error during getting csv, returning latest value instead.", e);
        }

        return currentValue;
    }
}
