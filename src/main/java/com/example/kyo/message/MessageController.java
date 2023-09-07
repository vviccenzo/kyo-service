package com.example.kyo.message;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.message.definition.MessageSendBean;
import com.example.kyo.message.definition.MessageAudioBean;
import com.example.kyo.message.definition.MessageBean;

@RestController
@RequestMapping(path = "/kyo/message")
public class MessageController {

	@Autowired
	private MessageService service;

	@PostMapping(path = "/send-message", consumes = MediaType.APPLICATION_JSON_VALUE)
	private MessageBean sendMessage(@RequestBody MessageSendBean bean) throws IOException {
		return this.service.sendMessage(bean);
	}

	@PostMapping(path = "/send-message-audio", consumes = MediaType.APPLICATION_JSON_VALUE)
	private MessageBean sendMessageAudio(@RequestBody MessageAudioBean bean) throws IOException {
		return this.service.sendMessageAudio(bean);
	}

	@GetMapping(path = "find-by-conversation", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<MessageBean> findAllByConversation(@RequestParam("userId") Long userId, @RequestParam("targetId") Long targetId) {
		return this.service.findAllByConversation(userId, targetId);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private MessageBean receiveMessage(@RequestParam("id") Long id) {
		return this.service.receiveMessage(id);
	}
}
