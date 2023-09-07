package com.example.kyo.user.definition;

import java.util.Date;

import com.example.kyo.levelpermission.LevelPermissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "nickname")
	private String nickName;

	@Column(name = "password")
	private String password;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "level_permission")
	private LevelPermissionType levelPermission;

	public UserModel(Long id, String name, String email, String nickName, String password, Date createdAt,
			LevelPermissionType levelPermission) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.createdAt = createdAt;
		this.levelPermission = levelPermission;
	}
}