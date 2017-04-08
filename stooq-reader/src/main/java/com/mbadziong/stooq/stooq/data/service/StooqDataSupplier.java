package com.mbadziong.stooq.stooq.data.service;

import com.mbadziong.stooq.stooq.data.model.MarketIndex;

import java.math.BigDecimal;

public interface StooqDataSupplier {
    BigDecimal getWig();

    BigDecimal getWig20();

    BigDecimal getWig20Fut();

    BigDecimal getMgiw40();

    BigDecimal getSwig80();

    MarketIndex getAll();
}
