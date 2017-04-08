package com.mbadziong.stooq.stooq.report.model;

import com.mbadziong.stooq.stooq.data.model.MarketIndex;

import java.time.LocalDateTime;

public class ReportRow {

    private MarketIndex marketIndex;
    private LocalDateTime time;

    public ReportRow(MarketIndex marketIndex) {
        this.marketIndex = marketIndex;
        this.time = LocalDateTime.now();
    }

    public MarketIndex getMarketIndex() {
        return marketIndex;
    }

    public void setMarketIndex(MarketIndex marketIndex) {
        this.marketIndex = marketIndex;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return time.toString() + ","
                + marketIndex.getWig() + ","
                + marketIndex.getWig20() + ","
                + marketIndex.getWig20fut() + ","
                + marketIndex.getMwig40() + ","
                + marketIndex.getSwig80();
    }
}
