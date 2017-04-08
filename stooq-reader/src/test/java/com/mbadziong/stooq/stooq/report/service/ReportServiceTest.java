package com.mbadziong.stooq.stooq.report.service;

import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import com.mbadziong.stooq.stooq.report.ReportWriter;
import com.mbadziong.stooq.testdata.SampleMarketIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTest {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private ReportWriter reportWriter;

    @Test
    public void testHandleNewMarketIndex_validMarketIndex() throws Exception {
        reportService.handleNewMarketIndex(SampleMarketIndex.MARKET_INDEX);

        verify(reportWriter, times(1)).writeToFile(SampleMarketIndex.MARKET_INDEX);
    }

    @Test
    public void testHandleNewMarketIndex_invalidMarketIndex() throws Exception {
        MarketIndex marketIndex = SampleMarketIndex.MARKET_INDEX_WITH_NULL;

        reportService.handleNewMarketIndex(marketIndex);

        verify(reportWriter, times(0)).writeToFile(SampleMarketIndex.MARKET_INDEX);
    }

    @Test
    public void testHandleNewMarketIndex_twoTimesTheSameMarketIndex() throws Exception {
        reportService.handleNewMarketIndex(SampleMarketIndex.MARKET_INDEX);
        reportService.handleNewMarketIndex(SampleMarketIndex.MARKET_INDEX);

        verify(reportWriter, times(1)).writeToFile(SampleMarketIndex.MARKET_INDEX);
    }

}