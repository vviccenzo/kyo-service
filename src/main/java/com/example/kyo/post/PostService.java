package com.example.kyo.post;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kyo.community.CommunityService;
import com.example.kyo.community.definition.CommunityModel;
import com.example.kyo.post.definition.PostCreateDTO;
import com.example.kyo.post.definition.PostDTO;
import com.example.kyo.post.definition.PostModel;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserModel;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CommunityService communityService;

	private PostFactory postFactory = new PostFactory();

	public List<PostDTO> getAll() {
		return this.postRepository.findAll()
				.stream()
				.map(this.postFactory::buildDTO)
				.collect(Collectors.toList());
	}

	public void create(PostCreateDTO dto) {
		PostModel post = this.postFactory.buildModel(dto);
		UserModel user = this.userService.findById(dto.getAuthorId());

		if(dto.getCommunityId() != null) {
			CommunityModel community = this.communityService.getCommunityById(dto.getCommunityId());
			post.setCommunity(community);
		}

		post.setAuthor(user);

		this.postRepository.save(post);
	}

	public List<PostDTO> getAllByUserId(Long userId) {
		return this.postRepository.findAllById(userId)
				.stream()
				.map(postFactory::buildDTO)
				.collect(Collectors.toList());
	}

	public PostModel getById(Long postId) {
		return this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not founded"));
	}
}
