package com.mbadziong.stooq.stooq.data.marketindex;


import com.mbadziong.stooq.stooq.data.model.StooqMarketIndex;
import com.mbadziong.stooq.stooq.data.parser.StooqCsvParser;
import com.mbadziong.stooq.stooq.exception.CsvFormatException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public abstract class MarketIndexDownloader {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MarketIndexDownloader.class);

    protected final static String STOOQ_URL = "https://stooq.pl/q/l/?s=%s&f=sd2t2ohlc&h&e=csv";

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private StooqCsvParser stooqCsvParser;

    protected StooqMarketIndex stooqMarketIndex;

    protected String lastValue;

    public String getCurrentValue() {
        LOGGER.info(String.format(STOOQ_URL, stooqMarketIndex.stockMarketIndex()));
        String response = restTemplate.getForObject(
                String.format(STOOQ_URL, stooqMarketIndex.stockMarketIndex()),
                String.class);

        try {
            return stooqCsvParser.getMarketIndexValue(response);
        } catch (CsvFormatException e) {
            return lastValue;
        }
    }
}
