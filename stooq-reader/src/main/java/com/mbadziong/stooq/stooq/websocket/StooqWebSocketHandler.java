package com.mbadziong.stooq.stooq.websocket;

import com.google.gson.Gson;
import com.mbadziong.stooq.stooq.data.model.MarketIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class StooqWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(StooqWebSocketHandler.class);

    private static List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("connected");
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("disconnected");
        sessions.remove(session);
    }

    public void broadcast(MarketIndex marketIndex) throws IOException {
        for(WebSocketSession webSocketSession : sessions) {
            LOGGER.info("Broadcasting to session...");
            webSocketSession.sendMessage(new TextMessage(new Gson().toJson(marketIndex)));
        }
    }
}
