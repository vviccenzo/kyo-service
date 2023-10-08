package com.example.kyo.user.friendRequest.definition;

import java.util.Date;

import com.example.kyo.notification.definition.NotificationModel;
import com.example.kyo.user.definition.UserModel;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "friend_request")
public class FriendRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	private UserModel receiver;

	@ManyToOne
	private UserModel sender;

	@Column(name = "status_type")
	private StatusType status;

	@Column(name = "requested_date")
	private Date requestDate;

	@Column(name = "responded_date")
	private Date respondedDate;

	@OneToOne
	private NotificationModel notification;
}
