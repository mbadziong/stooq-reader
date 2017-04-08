package com.mbadziong.stooq.task;

import com.mbadziong.stooq.stooq.data.service.StooqDataSupplier;
import com.mbadziong.stooq.stooq.report.service.ReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StooqTask {

    public StooqTask(StooqDataSupplier stooqDataSupplier, ReportService reportService) {
        this.stooqDataSupplier = stooqDataSupplier;
        this.reportService = reportService;
    }

    private StooqDataSupplier stooqDataSupplier;

    private ReportService reportService;

    @Scheduled(fixedDelayString = "${interval}")
    public void fetchMarketIndex() {
        reportService.handleNewMarketIndex(stooqDataSupplier.getAll());
    }
}
