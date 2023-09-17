package com.example.kyo.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.community.definition.CommunityCreateDTO;
import com.example.kyo.community.definition.CommunityDTO;

@RestController
@RequestMapping(path = "/kyo/community")
public class CommunityController {

	@Autowired
	private CommunityService communityService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommunityDTO create(@ModelAttribute CommunityCreateDTO dto) {
		return this.communityService.create(dto);
	}

	@GetMapping
	public List<CommunityDTO> getAll() {
		return this.communityService.getAll();
	}

	@PutMapping(path = "/add-on-community")
	public void addOnCommunity(@RequestParam("communityId") Long communityId, @RequestParam("userId") Long userId) {
		this.communityService.addOnCommunity(communityId, userId);
	}

	@PutMapping(path = "/turn-admin")
	public void turnAdmin(@RequestParam("communityId") Long communityId, @RequestParam("userId") Long userId) {
		this.communityService.turnAdmin(communityId, userId);
	}

	@PutMapping(path = "/add-topic")
	public void addTopic(@RequestParam("communityId") Long communityId, @RequestParam("topicId") Long topicId) {
		this.communityService.addTopic(communityId, topicId);
	}
}
