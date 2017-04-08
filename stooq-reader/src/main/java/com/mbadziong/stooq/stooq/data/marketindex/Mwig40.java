package com.mbadziong.stooq.stooq.data.marketindex;

import com.mbadziong.stooq.stooq.data.model.StooqMarketIndex;
import com.mbadziong.stooq.stooq.data.parser.StooqCsvParser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Mwig40 extends StooqMarketIndexDownloader {

    public Mwig40(RestTemplate restTemplate, StooqCsvParser stooqCsvParser) {
        super(restTemplate, stooqCsvParser);
        stooqMarketIndex = StooqMarketIndex.MWIG40;
    }
}
