package com.example.kyo.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kyo.community.definition.CommunityCreateDTO;
import com.example.kyo.community.definition.CommunityDTO;
import com.example.kyo.community.definition.CommunityModel;
import com.example.kyo.community.topic.TopicService;
import com.example.kyo.community.topic.definition.TopicModel;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserModel;

@Service
public class CommunityService {

	private CommunityFactory communityFactory = new CommunityFactory();

	@Autowired
	private CommunityRepository communityRepository;

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserService userService;

	public CommunityDTO create(CommunityCreateDTO dto) {
		return this.communityFactory.buildDTO(this.communityRepository.save(this.communityFactory.buildModel(dto)));
	}

	public List<CommunityDTO> getAll() {
		return this.communityRepository.findAll().stream().map(this.communityFactory::buildDTO).toList();
	}

	public void addOnCommunity(Long communityId, Long userId) {
		CommunityModel communityModel = this.getCommunityById(communityId);
		UserModel user = this.getUserById(userId);
		communityModel.getMembers().add(user);

		this.communityRepository.save(communityModel);
	}

	public void turnAdmin(Long communityId, Long userId) {
		CommunityModel communityModel = this.getCommunityById(communityId);
		UserModel user = this.getUserById(userId);
		communityModel.getAdmins().add(user);

		this.communityRepository.save(communityModel);
	}

	public CommunityModel getCommunityById(Long communityId) {
		return this.communityRepository.findById(communityId)
				.orElseThrow(() -> new RuntimeException("Community: " + communityId + " not found."));
	}

	private UserModel getUserById(Long userId) {
		UserModel user = this.userService.findById(userId);
		if (user == null) {
			throw new RuntimeException("User: " + userId + " not found.");
		}

		return user;
	}

	public void addTopic(Long communityId, Long topicId) {
		TopicModel topic = this.topicService.getById(topicId);
		CommunityModel community = this.getCommunityById(communityId);

		community.getTopics().add(topic);
		this.communityRepository.save(community);
	}
}
