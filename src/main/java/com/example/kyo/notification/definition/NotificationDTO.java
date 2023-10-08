package com.example.kyo.notification.definition;

import java.util.Date;

import com.example.kyo.user.definition.UserDTO;
import com.example.kyo.user.friendRequest.definition.FriendRequestDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDTO {

	private Long id;

	private NotificationType type;

	private UserDTO user;

	private Date receivedDate;

	private boolean wasSeen;

	private FriendRequestDTO request;
}
