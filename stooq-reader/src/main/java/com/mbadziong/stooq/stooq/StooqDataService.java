package com.mbadziong.stooq.stooq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StooqDataService {

    @Autowired
    private RestTemplate restTemplate;

    private final static Logger LOGGER = LoggerFactory.getLogger(StooqDataService.class);

    public void run() {
        String values = restTemplate.getForObject("https://stooq.pl/q/l/?s=wig&f=sd2t2ohlc&h&e=csv", String.class);
        LOGGER.info(values);
    }
}
