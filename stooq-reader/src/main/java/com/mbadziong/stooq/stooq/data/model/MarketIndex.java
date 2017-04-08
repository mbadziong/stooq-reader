package com.mbadziong.stooq.stooq.data.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class MarketIndex {
    private BigDecimal wig;
    private BigDecimal wig20;
    private BigDecimal wig20fut;
    private BigDecimal mwig40;
    private BigDecimal swig80;

    public MarketIndex(BigDecimal wig, BigDecimal wig20, BigDecimal wig20fut, BigDecimal mwig40, BigDecimal swig80) {
        this.wig = wig;
        this.wig20 = wig20;
        this.wig20fut = wig20fut;
        this.mwig40 = mwig40;
        this.swig80 = swig80;
    }

    public BigDecimal getWig() {
        return wig;
    }

    public void setWig(BigDecimal wig) {
        this.wig = wig;
    }

    public BigDecimal getWig20() {
        return wig20;
    }

    public void setWig20(BigDecimal wig20) {
        this.wig20 = wig20;
    }

    public BigDecimal getWig20fut() {
        return wig20fut;
    }

    public void setWig20fut(BigDecimal wig20fut) {
        this.wig20fut = wig20fut;
    }

    public BigDecimal getMwig40() {
        return mwig40;
    }

    public void setMwig40(BigDecimal mwig40) {
        this.mwig40 = mwig40;
    }

    public BigDecimal getSwig80() {
        return swig80;
    }

    public void setSwig80(BigDecimal swig80) {
        this.swig80 = swig80;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarketIndex) {
            MarketIndex other = (MarketIndex) obj;
            return Objects.equals(wig, other.wig) &&
                    Objects.equals(wig20, other.wig20) &&
                    Objects.equals(wig20fut, other.wig20fut) &&
                    Objects.equals(mwig40, other.mwig40) &&
                    Objects.equals(swig80, swig80);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wig, wig20, wig20fut, mwig40, swig80);
    }

    public boolean hasNulls() {
        return Arrays.asList(wig, wig20, wig20fut, mwig40, swig80).contains(null);
    }
}
