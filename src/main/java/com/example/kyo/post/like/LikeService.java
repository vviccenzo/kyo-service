package com.example.kyo.post.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kyo.post.PostService;
import com.example.kyo.post.definition.PostModel;
import com.example.kyo.post.like.definition.LikeModel;
import com.example.kyo.post.like.definition.LikePostDTO;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserModel;

@Service
public class LikeService {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@Autowired
	private LikeRepository likeRepository;

	private LikeFactory likeFactory = new LikeFactory();

	public Long likePost(LikePostDTO dto) {
		LikeModel liked = this.likeRepository.findByPostsIdAndUserId(dto.getPostId(), dto.getUserId());
		if (liked != null) {
			this.likeRepository.delete(liked);

			PostModel post = this.postService.getById(dto.getPostId());
			return (long) post.getLikes().size();
		} else {
			PostModel post = this.postService.getById(dto.getPostId());
			UserModel user = this.userService.findById(dto.getUserId());
			LikeModel like = this.likeFactory.buildModel(post, user);

			this.likeRepository.save(like);
			return (long) post.getLikes().size();
		}
	}
}
