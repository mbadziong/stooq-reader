package com.mbadziong.stooq.task;

import com.mbadziong.stooq.stooq.data.service.StooqDataSupplier;
import com.mbadziong.stooq.stooq.report.service.ReportService;
import com.mbadziong.stooq.stooq.websocket.StooqWebSocketHandler;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StooqTask {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StooqTask.class);

    private StooqDataSupplier stooqDataSupplier;

    private ReportService reportService;

    private StooqWebSocketHandler stooqWebSocketHandler;

    public StooqTask(StooqDataSupplier stooqDataSupplier, ReportService reportService, StooqWebSocketHandler stooqWebSocketHandler) {
        this.stooqDataSupplier = stooqDataSupplier;
        this.reportService = reportService;
        this.stooqWebSocketHandler = stooqWebSocketHandler;
    }

    @Scheduled(fixedDelayString = "${interval}")
    public void fetchMarketIndex() {
        try {
            stooqWebSocketHandler.broadcast();
        } catch (IOException e) {
            LOGGER.error("Websocket error");
        }
        reportService.handleNewMarketIndex(stooqDataSupplier.getAll());
    }
}
