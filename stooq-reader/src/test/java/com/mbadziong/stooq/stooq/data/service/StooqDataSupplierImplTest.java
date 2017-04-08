package com.mbadziong.stooq.stooq.data.service;

import com.mbadziong.stooq.stooq.data.marketindex.*;
import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import com.mbadziong.stooq.testdata.SampleMarketIndex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StooqDataSupplierImplTest {

    @InjectMocks
    private StooqDataSupplierImpl stooqDataSupplier;

    @Mock
    private Wig wig;

    @Mock
    private Wig20 wig20;

    @Mock
    private Wig20Fut wig20Fut;

    @Mock
    private Mwig40 mwig40;

    @Mock
    private Swig80 swig80;

    @Before
    public void setUp() throws Exception {
        when(wig.getCurrentValue()).thenReturn(SampleMarketIndex.WIG);
        when(wig20.getCurrentValue()).thenReturn(SampleMarketIndex.WIG20);
        when(wig20Fut.getCurrentValue()).thenReturn(SampleMarketIndex.WIG20FUT);
        when(mwig40.getCurrentValue()).thenReturn(SampleMarketIndex.MWIG40);
        when(swig80.getCurrentValue()).thenReturn(SampleMarketIndex.SWIG80);
    }

    @Test
    public void testGetWig() throws Exception {
        BigDecimal wig = stooqDataSupplier.getWig();

        assertEquals(SampleMarketIndex.WIG, wig);
    }

    @Test
    public void testGetWig20() throws Exception {
        BigDecimal wig20 = stooqDataSupplier.getWig20();

        assertEquals(SampleMarketIndex.WIG20, wig20);
    }

    @Test
    public void testGetWig20Fut() throws Exception {
        BigDecimal wig20fut = stooqDataSupplier.getWig20Fut();

        assertEquals(SampleMarketIndex.WIG20FUT, wig20fut);
    }

    @Test
    public void testGetMgiw40() throws Exception {
        BigDecimal mwig40 = stooqDataSupplier.getMgiw40();

        assertEquals(SampleMarketIndex.MWIG40, mwig40);
    }

    @Test
    public void testGetSwig80() throws Exception {
        BigDecimal swig80 = stooqDataSupplier.getSwig80();

        assertEquals(SampleMarketIndex.SWIG80, swig80);
    }

    @Test
    public void testGetAll() throws Exception {
        MarketIndex current = stooqDataSupplier.getAll();

        assertEquals(SampleMarketIndex.MARKET_INDEX, current);
    }
}