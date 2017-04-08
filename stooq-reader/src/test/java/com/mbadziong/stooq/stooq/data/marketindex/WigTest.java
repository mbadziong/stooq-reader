package com.mbadziong.stooq.stooq.data.marketindex;

import com.mbadziong.stooq.stooq.data.exception.CsvFormatException;
import com.mbadziong.stooq.stooq.data.parser.StooqCsvParser;
import com.mbadziong.stooq.testdata.SampleCsv;
import com.mbadziong.stooq.testdata.SampleMarketIndex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WigTest {

    @InjectMocks
    private Wig wig;

    @Mock
    private StooqCsvParser stooqCsvParser;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        when(restTemplate.getForObject(any(String.class), eq(String.class))).thenReturn(SampleCsv.VALID_CSV);
        when(stooqCsvParser.getMarketIndexValue(SampleCsv.VALID_CSV)).thenReturn(SampleMarketIndex.VALID_WIG);
    }

    @Test
    public void testGetCurrentValue() {
        BigDecimal current = wig.getCurrentValue();

        assertEquals(SampleMarketIndex.VALID_WIG, current);
    }

    @Test
    public void testGetCurrentValue_returnLatestValueIfParserError() throws CsvFormatException {
        BigDecimal current = wig.getCurrentValue();

        assertEquals(SampleMarketIndex.VALID_WIG, current);

        when(stooqCsvParser.getMarketIndexValue(SampleCsv.VALID_CSV)).thenThrow(CsvFormatException.class);

        current = wig.getCurrentValue();

        assertEquals(SampleMarketIndex.VALID_WIG, current);
    }

    @Test
    public void testGetCurrentValue_returnLatestValueIfHttpClientError() {
        BigDecimal current = wig.getCurrentValue();

        assertEquals(SampleMarketIndex.VALID_WIG, current);

        when(restTemplate.getForObject(any(String.class), eq(String.class))).thenThrow(RestClientException.class);

        current = wig.getCurrentValue();

        assertEquals(SampleMarketIndex.VALID_WIG, current);
    }
}