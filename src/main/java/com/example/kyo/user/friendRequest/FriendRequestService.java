package com.example.kyo.user.friendRequest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kyo.notification.NotificationService;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.friendRequest.definition.FriendRequestDTO;
import com.example.kyo.user.friendRequest.definition.FriendRequestFactory;
import com.example.kyo.user.friendRequest.definition.FriendRequestModel;
import com.example.kyo.user.friendRequest.definition.StatusType;

@Service
public class FriendRequestService {

	@Autowired
	private FriendRequestRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private NotificationService notificationService;

	private FriendRequestFactory factory = new FriendRequestFactory();

	public void sendRequest(Long senderId, Long receiverId) {
		UserModel sender = this.userService.findById(senderId);
		UserModel receiver = this.userService.findById(receiverId);

		FriendRequestModel request = FriendRequestModel.builder()
				.sender(sender)
				.receiver(receiver)
				.status(StatusType.PENDING)
				.requestDate(new Date())
				.build();

		this.repository.save(request);
		this.notificationService.createNotificationFriendRequest(receiver, request);
	}

	public List<FriendRequestDTO> findAllByUser(Long userId) {
		List<FriendRequestModel> models = this.repository.findAllByReceiverId(userId);

		return this.factory.buildListDto(models);
	}

	public void respondRequest(Long id, StatusType status) {
		FriendRequestModel request = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));

		request.setStatus(status);
		request.setRespondedDate(new Date());

		this.repository.save(request);

		if (StatusType.ACCEPTED.equals(status)) {
			UserModel receiver = request.getReceiver();
			UserModel sender = request.getSender();

			receiver.getFriends().add(sender);
			sender.getFriends().add(receiver);

			this.userService.saveUser(sender);
			this.userService.saveUser(receiver);
		}
	}

	public void saveRequest(FriendRequestModel model) {
		this.repository.save(model);
	}
}
