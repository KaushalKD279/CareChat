//package com.kaushal.carechat.config;
//
//public class WebSocketConfig {
//
//}

package com.kaushal.carechat.config;

import com.kaushal.carechat.websocket.ChatHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        System.out.println("Registering WebSocket endpoint: /chat");

        registry.addHandler(chatHandler(), "/chat")
                .setAllowedOrigins("*");

    }

    @Bean
    public ChatHandler chatHandler() {
        return new ChatHandler();
    }

}