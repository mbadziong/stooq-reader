package com.mbadziong.stooq.stooq;

import com.mbadziong.stooq.stooq.data.service.StooqDataSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StooqDataService {

    @Autowired
    private StooqDataSupplier stooqDataSupplier;

    private final static Logger LOGGER = LoggerFactory.getLogger(StooqDataService.class);

    public void run() {
        BigDecimal value = stooqDataSupplier.getWig();
        LOGGER.info("wig value: " + value.doubleValue());
    }
}
