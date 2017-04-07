package com.mbadziong.stooq.stooq.data.marketindex;

import com.mbadziong.stooq.stooq.data.model.StooqMarketIndex;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Swig80 extends MarketIndexDownloader {

    @PostConstruct
    public void init() {
        this.stooqMarketIndex = StooqMarketIndex.SWIG80;
    }
}
