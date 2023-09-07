package com.example.kyo.message.definition;

import java.util.Date;

import com.example.kyo.user.definition.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "message_user")
public class MessageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "message")
	private String message;

	@ManyToOne
	private UserModel user;

	@ManyToOne
	private UserModel target;

	@Column(name = "received_date")
	private Date receivedDate;

	@Column(name = "created_at")
	private Date createdAt;

	@Lob
	@Column(name = "image")
	private byte[] image;

	@Lob
	@Column(name = "audio")
	private byte[] audio;

	public MessageModel(String message, UserModel user, UserModel target, Date createdAt) {
		super();
		this.message = message;
		this.user = user;
		this.target = target;
		this.createdAt = createdAt;
	}
}
