package com.mbadziong.stooq.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StooqDataService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StooqDataService.class);

    public void run() {
        LOGGER.info("http response");
    }
}
