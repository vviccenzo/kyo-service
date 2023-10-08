package com.example.kyo.user.definition;

import com.example.kyo.generic.definition.GenericDTO;
import com.example.kyo.levelpermission.LevelPermissionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserSaveBean extends GenericDTO {

	private String name;
	private String email;
	private String nickName;
	private String password;
	private LevelPermissionType levelPermissionType;
	private String avatarPath;
}
