package com.example.kyo.websocket;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kyo.message.MessageService;
import com.example.kyo.message.definition.MessageBean;
import com.example.kyo.message.definition.MessageSendBean;

@Controller
public class WebSocketController {

	@Autowired
	private MessageService messageService;

	@PostMapping(path = "/send-message", consumes = MediaType.APPLICATION_JSON_VALUE)
	@SendTo("/chat/reload")
	private MessageBean sendMessage(@Payload MessageSendBean bean) throws IOException {
		return this.messageService.sendMessage(bean);
	}
}
