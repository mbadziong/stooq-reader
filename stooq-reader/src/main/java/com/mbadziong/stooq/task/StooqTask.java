package com.mbadziong.stooq.task;

import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import com.mbadziong.stooq.stooq.data.service.StooqDataService;
import com.mbadziong.stooq.stooq.report.model.ReportRow;
import com.mbadziong.stooq.stooq.report.service.ReportService;
import com.mbadziong.stooq.stooq.websocket.StooqWebSocketHandler;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class StooqTask {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StooqTask.class);

    private StooqDataService stooqDataService;

    private ReportService reportService;

    private StooqWebSocketHandler stooqWebSocketHandler;

    public StooqTask(StooqDataService stooqDataService, ReportService reportService, StooqWebSocketHandler stooqWebSocketHandler) {
        this.stooqDataService = stooqDataService;
        this.reportService = reportService;
        this.stooqWebSocketHandler = stooqWebSocketHandler;
    }

    @Scheduled(fixedDelayString = "${interval}")
    public void fetchMarketIndex() {
        Optional<MarketIndex> marketIndex = reportService.handleNewMarketIndex(stooqDataService.getAll());
        if(marketIndex.isPresent()) {
            try {
                stooqWebSocketHandler.broadcast(new ReportRow(marketIndex.get()));
            } catch (IOException e) {
                LOGGER.error("Websocket error", e);
            }
        }
    }
}
