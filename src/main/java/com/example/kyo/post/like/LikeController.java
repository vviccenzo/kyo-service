package com.example.kyo.post.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.post.like.definition.LikePostDTO;

@RestController
@RequestMapping("/kyo/post/like")
public class LikeController {

	@Autowired
	private LikeService likeService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void likePost(@ModelAttribute LikePostDTO dto) {
		this.likeService.likePost(dto);
	}
}
