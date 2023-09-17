package com.example.kyo.post.like;

import com.example.kyo.post.definition.PostModel;
import com.example.kyo.post.like.definition.LikeModel;
import com.example.kyo.user.definition.UserModel;

public class LikeFactory {

	public LikeModel buildModel(PostModel post, UserModel user) {
		return LikeModel.builder()
				.posts(post)
				.user(user)
				.build();
	}
}
