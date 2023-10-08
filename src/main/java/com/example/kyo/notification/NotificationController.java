package com.example.kyo.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.notification.definition.NotificationDTO;

@RestController
@RequestMapping("/kyo/notification")
public class NotificationController {

	@Autowired
	private NotificationService service;

	@MessageMapping("/list")
	public List<NotificationDTO> findAllByUser(@RequestParam("user") Long userId) {
		return this.service.findAllByUser(userId);
	}
}
