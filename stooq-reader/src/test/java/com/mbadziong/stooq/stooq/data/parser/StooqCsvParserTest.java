package com.mbadziong.stooq.stooq.data.parser;

import com.mbadziong.stooq.testdata.SampleCsv;
import com.mbadziong.stooq.testdata.SampleMarketIndex;
import com.mbadziong.stooq.stooq.data.exception.CsvFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StooqCsvParserTest {

    @Autowired
    private StooqCsvParser stooqCsvParser;

    @Test
    public void testGetMarketIndexValue_ValidCsv() throws Exception {
        BigDecimal marketIndex = stooqCsvParser.getMarketIndexValue(SampleCsv.VALID_CSV);

        assertEquals(SampleMarketIndex.VALID_WIG, marketIndex);
    }

    @Test(expected = CsvFormatException.class)
    public void testGetMarketIndexValue_InvalidCsv() throws CsvFormatException {
        stooqCsvParser.getMarketIndexValue(SampleCsv.INVALID_CSV);
    }

    @Test(expected = CsvFormatException.class)
    public void testGetMarketIndexValue_EmptyCsv() throws CsvFormatException {
        stooqCsvParser.getMarketIndexValue(SampleCsv.EMPTY_CSV);
    }
}