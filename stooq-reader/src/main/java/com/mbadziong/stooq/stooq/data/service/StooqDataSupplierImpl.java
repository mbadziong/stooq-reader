package com.mbadziong.stooq.stooq.data.service;

import com.mbadziong.stooq.stooq.data.marketindex.*;
import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StooqDataSupplierImpl implements StooqDataSupplier {

    private Wig wig;

    private Wig20 wig20;

    private Wig20Fut wig20Fut;

    private Mwig40 mwig40;

    private Swig80 swig80;

    public StooqDataSupplierImpl(Wig wig, Wig20 wig20, Wig20Fut wig20Fut, Mwig40 mwig40, Swig80 swig80) {
        this.wig = wig;
        this.wig20 = wig20;
        this.wig20Fut = wig20Fut;
        this.mwig40 = mwig40;
        this.swig80 = swig80;
    }

    @Override
    public BigDecimal getWig() {
        return wig.getCurrentValue();
    }

    @Override
    public BigDecimal getWig20() {
        return wig20.getCurrentValue();
    }

    @Override
    public BigDecimal getWig20Fut() {
        return wig20Fut.getCurrentValue();
    }

    @Override
    public BigDecimal getMgiw40() {
        return mwig40.getCurrentValue();
    }

    @Override
    public BigDecimal getSwig80() {
        return swig80.getCurrentValue();
    }

    @Override
    public MarketIndex getAll() {
        return new MarketIndex(
                getWig(),
                getWig20(),
                getWig20Fut(),
                getMgiw40(),
                getSwig80()
        );
    }
}
