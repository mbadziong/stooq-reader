package com.mbadziong.stooq.stooq;

import com.mbadziong.stooq.stooq.data.marketindex.*;
import com.mbadziong.stooq.stooq.data.parser.StooqCsvParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StooqDataService {

    @Autowired
    private Wig wig;

    @Autowired
    private Wig20 wig20;

    @Autowired
    private Wig20Fut wig20Fut;

    @Autowired
    private Mwig40 mwig40;

    @Autowired
    private Swig80 swig80;

    @Autowired
    private StooqCsvParser stooqCsvParser;

    private final static Logger LOGGER = LoggerFactory.getLogger(StooqDataService.class);

    public void run() {
        String value = wig.getCurrentValue();
        LOGGER.info(value);
    }
}
