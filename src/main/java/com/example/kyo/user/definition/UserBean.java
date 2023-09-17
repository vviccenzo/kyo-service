package com.example.kyo.user.definition;

import java.util.Date;

import com.example.kyo.generic.definition.GenericBean;
import com.example.kyo.levelpermission.LevelPermissionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserBean extends GenericBean{
	
	private String name;
	private String email;
	private String nickName;
	private Date createdAt;
	private LevelPermissionType levelPermissionType;
}
