package com.mbadziong.stooq.testdata;

import com.mbadziong.stooq.stooq.data.model.MarketIndex;

import java.math.BigDecimal;

public class SampleMarketIndex {
    public static final BigDecimal VALID_WIG = new BigDecimal("59406.36");

    public static final BigDecimal WIG = BigDecimal.valueOf(1.11);
    public static final BigDecimal WIG20 = BigDecimal.valueOf(2.22);
    public static final BigDecimal WIG20FUT = BigDecimal.valueOf(3.33);
    public static final BigDecimal MWIG40 = BigDecimal.valueOf(4.44);
    public static final BigDecimal SWIG80 = BigDecimal.valueOf(5.55);

    public static final MarketIndex MARKET_INDEX = new MarketIndex(
            WIG,
            WIG20,
            WIG20FUT,
            MWIG40,
            SWIG80
    );

    public static final MarketIndex MARKET_INDEX_WITH_NULL = new MarketIndex(
            WIG,
            WIG20,
            null,
            MWIG40,
            SWIG80
    );
}
