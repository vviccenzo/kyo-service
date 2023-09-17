package com.example.kyo.user.definition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserUpdateDTO {

	private Long userId;
	private String name;
	private String nickName;
	private String avatarPath;
}
