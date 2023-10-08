package com.example.kyo.user.friendRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.user.friendRequest.definition.FriendRequestDTO;
import com.example.kyo.user.friendRequest.definition.StatusType;

@RestController
@RequestMapping("/kyo/user/friendRequest")
public class FriendRequestController {

	@Autowired
	private FriendRequestService service;

	@PostMapping
	@SendTo("/topic/notification")
	public void sendFriendRequest(@RequestParam("sender") Long senderId, @RequestParam("receiver") Long receiverId) {
		this.service.sendRequest(senderId, receiverId);
	}

	@GetMapping(path = "/find-by-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FriendRequestDTO> findByUser(@RequestParam("user") Long userId) {
		return this.service.findAllByUser(userId);
	}

	@PutMapping
	public void respondRequest(@RequestParam("id") Long id, @RequestParam("status") StatusType status) {
		this.service.respondRequest(id, status);
	}
}
