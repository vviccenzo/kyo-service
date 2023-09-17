package com.example.kyo.post.definition;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreateDTO {

	private String content;
	private Long authorId;
	private Long communityId;
}
