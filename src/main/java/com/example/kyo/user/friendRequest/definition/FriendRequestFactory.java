package com.example.kyo.user.friendRequest.definition;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kyo.user.UserFactory;

public class FriendRequestFactory {

	private UserFactory factory = new UserFactory();

	public List<FriendRequestDTO> buildListDto(List<FriendRequestModel> models) {
		return models.stream().map(this::buildDto).collect(Collectors.toList());
	}

	public FriendRequestDTO buildDto(FriendRequestModel model) {
		return FriendRequestDTO.builder()
				.sender(this.factory.buildDTO(model.getSender()))
				.receiver(this.factory.buildDTO(model.getReceiver()))
				.id(model.getId())
				.build();
	}
}
