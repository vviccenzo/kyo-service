package com.example.kyo.community.definition;

import java.util.List;

import com.example.kyo.community.visibility.enumeration.VisibilityEnum;
import com.example.kyo.user.definition.UserModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommunityDTO {

	private String name;
	private String description;
	private VisibilityEnum visibility;
	private List<UserModel> admins;
	private List<UserModel> members;
}
