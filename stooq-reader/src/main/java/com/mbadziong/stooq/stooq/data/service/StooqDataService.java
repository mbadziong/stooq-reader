package com.mbadziong.stooq.stooq.data.service;

import com.mbadziong.stooq.stooq.data.marketindex.Mwig40;
import com.mbadziong.stooq.stooq.data.marketindex.Swig80;
import com.mbadziong.stooq.stooq.data.marketindex.Wig;
import com.mbadziong.stooq.stooq.data.marketindex.Wig20;
import com.mbadziong.stooq.stooq.data.marketindex.Wig20Fut;
import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StooqDataService {

    private Wig wig;

    private Wig20 wig20;

    private Wig20Fut wig20Fut;

    private Mwig40 mwig40;

    private Swig80 swig80;

    public StooqDataService(Wig wig, Wig20 wig20, Wig20Fut wig20Fut, Mwig40 mwig40, Swig80 swig80) {
        this.wig = wig;
        this.wig20 = wig20;
        this.wig20Fut = wig20Fut;
        this.mwig40 = mwig40;
        this.swig80 = swig80;
    }

    public BigDecimal getWig() {
        return wig.getCurrentValue();
    }

    public BigDecimal getWig20() {
        return wig20.getCurrentValue();
    }

    public BigDecimal getWig20Fut() {
        return wig20Fut.getCurrentValue();
    }

    public BigDecimal getMgiw40() {
        return mwig40.getCurrentValue();
    }

    public BigDecimal getSwig80() {
        return swig80.getCurrentValue();
    }

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
