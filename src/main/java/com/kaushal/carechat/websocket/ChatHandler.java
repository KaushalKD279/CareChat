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

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

public class ChatHandler extends TextWebSocketHandler {

    // Stores all connected browser sessions
    private final Set<WebSocketSession> sessions = new HashSet<>();

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

        System.out.println("--------------------------------");
        System.out.println("Message Received");
        System.out.println("From Session : " + session.getId());
        System.out.println("Message      : " + message.getPayload());
        System.out.println("--------------------------------");

        for (WebSocketSession client : sessions) {

            if (client.isOpen()) {

                client.sendMessage(
                        new TextMessage(message.getPayload())
                );

            }

        }

    }

}