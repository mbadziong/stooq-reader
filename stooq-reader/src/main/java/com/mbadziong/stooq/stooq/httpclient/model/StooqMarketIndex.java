package com.mbadziong.stooq.stooq.httpclient.model;

public enum StooqMarketIndex {
    WIG("wig"),
    WIG20("wig20"),
    WIG20FUT("fw20"),
    MWIG40("mwig40"),
    SWIG80("swig80");

    private String stockMarketIndex;

    StooqMarketIndex(String stockMarketIndex) {
        this.stockMarketIndex = stockMarketIndex;
    }

    public String stockMarketIndex() {
        return this.stockMarketIndex;
    }
}
