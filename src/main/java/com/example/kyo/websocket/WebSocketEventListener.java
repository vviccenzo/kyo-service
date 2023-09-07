package com.example.kyo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.kyo.message.definition.MessageModel;
import com.example.kyo.user.UserService;

import io.micrometer.common.util.StringUtils;

@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@Autowired
	private UserService userService;

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("New connection websocket");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");

		if(StringUtils.isNotBlank(username)) {
			logger.info("Usuário desconectado: " + username);

			MessageModel message = new MessageModel();
			message.setMessage("Usuário " + username + " saiu do chat.");
			message.setUser(this.userService.findByName(username));
			message.setTarget(this.userService.findByName(username));

			this.messagingTemplate.convertAndSend("", message);
		}
	}
}
