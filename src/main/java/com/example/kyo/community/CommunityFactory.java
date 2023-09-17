package com.example.kyo.community;

import java.util.Date;

import com.example.kyo.community.definition.CommunityCreateDTO;
import com.example.kyo.community.definition.CommunityDTO;
import com.example.kyo.community.definition.CommunityModel;

public class CommunityFactory {

	public CommunityModel buildModel(CommunityCreateDTO dto) {
		return CommunityModel
				.builder()
				.name(dto.getName())
				.description(dto.getDescription())
				.visibility(dto.getVisibility())
				.createdDate(new Date())
				.build();
	}

	public CommunityDTO buildDTO(CommunityModel model) {
		return CommunityDTO
				.builder()
				.name(model.getName())
				.description(model.getDescription())
				.visibility(model.getVisibility())
				.admins(model.getAdmins())
				.members(model.getMembers())
				.build();
	}
}
