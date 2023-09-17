package com.example.kyo.post;

import com.example.kyo.post.definition.PostCreateDTO;
import com.example.kyo.post.definition.PostDTO;
import com.example.kyo.post.definition.PostModel;
import com.example.kyo.user.UserFactory;

public class PostFactory {

	private UserFactory userFactory;

	public PostDTO buildDTO(PostModel model) {
		return PostDTO
				.builder()
				.author(this.userFactory.buildDTO(model.getAuthor()))
				.content(model.getContent())
				.createdAt(model.getCreatedAt())
				.community(null)
				.id(model.getId())
				.build();
	}

	public PostModel buildModel(PostCreateDTO dto) {
		return PostModel
				.builder()
				.content(dto.getContent())
				.build();
	}
}
