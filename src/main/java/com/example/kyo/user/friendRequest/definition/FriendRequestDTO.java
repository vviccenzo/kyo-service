package com.example.kyo.user.friendRequest.definition;

import com.example.kyo.user.definition.UserDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendRequestDTO {

	private Long id;
	private UserDTO sender;
	private UserDTO receiver;
}
