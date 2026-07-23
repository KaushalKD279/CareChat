////package com.kaushal.carechat.websocket;
////
////public class ChatHandler {
////
////}
//
//package com.kaushal.carechat.websocket;
//
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//public class ChatHandler extends TextWebSocketHandler {
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session,
//                                     TextMessage message) throws Exception {
//
//        System.out.println("Received: " + message.getPayload());
//
//        session.sendMessage(new TextMessage("Server: " + message.getPayload()));
//
//    }
//
//}


package com.kaushal.carechat.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaushal.carechat.model.ChatMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

public class ChatHandler extends TextWebSocketHandler {

    // Stores all connected browser sessions
    private final Set<WebSocketSession> sessions = new HashSet<>();

    // Converts Java Objects <-> JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessions.add(session);

        System.out.println("--------------------------------");
        System.out.println("New Client Connected");
        System.out.println("Session ID : " + session.getId());
        System.out.println("Total Connected Clients : " + sessions.size());
        System.out.println("--------------------------------");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus status) throws Exception {

        sessions.remove(session);

        System.out.println("--------------------------------");
        System.out.println("Client Disconnected");
        System.out.println("Session ID : " + session.getId());
        System.out.println("Total Connected Clients : " + sessions.size());
        System.out.println("--------------------------------");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {

        // Convert incoming JSON to ChatMessage object
        ChatMessage chatMessage = objectMapper.readValue(
                message.getPayload(),
                ChatMessage.class
        );

        System.out.println("--------------------------------");
        System.out.println("Message Received");
        System.out.println("From Session : " + session.getId());
        System.out.println("Sender       : " + chatMessage.getSender());
        System.out.println("Content      : " + chatMessage.getContent());
        System.out.println("--------------------------------");

        // Convert ChatMessage object back to JSON
        String jsonMessage = objectMapper.writeValueAsString(chatMessage);

        // Broadcast JSON to all connected clients
        for (WebSocketSession client : sessions) {

            if (client.isOpen()) {

                client.sendMessage(
                        new TextMessage(jsonMessage)
                );

            }

        }

    }

}