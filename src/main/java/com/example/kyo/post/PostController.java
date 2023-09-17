package com.example.kyo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.post.definition.PostCreateDTO;
import com.example.kyo.post.definition.PostDTO;

@RestController
@RequestMapping(path = "/kyo/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PostDTO> getAll() {
		return this.postService.getAll();
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@ModelAttribute PostCreateDTO dto) {
		this.postService.create(dto);
	}

	@GetMapping(path = "get-by-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PostDTO> getAllByUserId(@RequestParam("userId") Long userId) {
		return this.postService.getAllByUserId(userId);
	}
}
