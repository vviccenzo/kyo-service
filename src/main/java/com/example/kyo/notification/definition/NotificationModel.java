package com.example.kyo.notification.definition;

import java.util.Date;

import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.friendRequest.definition.FriendRequestModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class NotificationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "notification_type")
	private NotificationType type;

	@ManyToOne
	private UserModel user;

	@Column(name = "received_date")
	private Date receivedDate;

	@Column(name = "was_seen")
	private boolean wasSeen;

	@JsonIgnore
	@OneToOne
	private FriendRequestModel request;
}
