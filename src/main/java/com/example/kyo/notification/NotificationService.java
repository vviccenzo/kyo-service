package com.example.kyo.notification;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.kyo.notification.definition.NotificationDTO;
import com.example.kyo.notification.definition.NotificationFactory;
import com.example.kyo.notification.definition.NotificationModel;
import com.example.kyo.notification.definition.NotificationType;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.friendRequest.FriendRequestService;
import com.example.kyo.user.friendRequest.definition.FriendRequestModel;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	private NotificationFactory factory = new NotificationFactory();

	public void createNotificationFriendRequest(UserModel user, FriendRequestModel request) {
		NotificationModel notification = NotificationModel.builder()
				.receivedDate(new Date())
				.request(request)
				.user(user)
				.type(NotificationType.FRIEND_REQUEST)
				.build();

		this.repository.save(notification);
		request.setNotification(notification);

		this.findAllByUser(user.getId());
	}

	public List<NotificationDTO> findAllByUser(Long userId) {
		List<NotificationModel> models = this.repository.findAllById(userId);
		List<NotificationDTO> dtos = this.factory.buildListDTO(models);
		dtos.stream().forEach(f -> {
			this.messagingTemplate.convertAndSend("/topic/notification", f);
		});

		return this.factory.buildListDTO(models);
	}
}
