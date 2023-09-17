package com.example.kyo.community.definition;

import java.util.List;

import com.example.kyo.community.visibility.enumeration.VisibilityEnum;

import lombok.Data;

@Data
public class CommunityCreateDTO {

	private String name;
	private String description;
	private VisibilityEnum visibility;
	private List<Long> admins;
	private List<Long> members;
}
