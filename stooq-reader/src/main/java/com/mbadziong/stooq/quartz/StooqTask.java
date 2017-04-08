package com.mbadziong.stooq.quartz;

import com.mbadziong.stooq.stooq.httpclient.service.StooqDataSupplier;
import com.mbadziong.stooq.stooq.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StooqTask {

    @Autowired
    private StooqDataSupplier stooqDataSupplier;

    @Autowired
    private ReportService reportService;

    public void run() {
        reportService.newValues(stooqDataSupplier.getAll());
    }
}
