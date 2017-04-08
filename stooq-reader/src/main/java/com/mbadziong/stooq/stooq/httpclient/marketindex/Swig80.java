package com.mbadziong.stooq.stooq.httpclient.marketindex;

import com.mbadziong.stooq.stooq.httpclient.model.StooqMarketIndex;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Swig80 extends StooqMarketIndexDownloader {

    @PostConstruct
    public void init() {
        this.stooqMarketIndex = StooqMarketIndex.SWIG80;
    }
}
