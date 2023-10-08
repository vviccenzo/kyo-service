package com.example.kyo.notification.definition;

import java.util.List;

import com.example.kyo.user.UserFactory;
import com.example.kyo.user.friendRequest.definition.FriendRequestFactory;

public class NotificationFactory {

	private FriendRequestFactory requestFactory = new FriendRequestFactory();

	private UserFactory userFactory = new UserFactory();

	public List<NotificationDTO> buildListDTO(List<NotificationModel> models) {
		return models.stream().map(this::buildDTO).toList();
	}

	public NotificationDTO buildDTO(NotificationModel model) {
		return NotificationDTO.builder()
				.id(model.getId())
				.receivedDate(model.getReceivedDate())
				.request(this.requestFactory.buildDto(model.getRequest()))
				.type(model.getType())
				.user(this.userFactory.buildDTO(model.getUser()))
				.wasSeen(model.isWasSeen())
				.build();
	}
}
