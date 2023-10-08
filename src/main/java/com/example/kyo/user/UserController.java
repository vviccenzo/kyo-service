package com.example.kyo.user;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.user.definition.UserDTO;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.definition.UserSaveBean;
import com.example.kyo.user.definition.UserUpdateDTO;

@RestController
@RequestMapping(path = "/kyo/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<UserDTO> findAll() {
		return this.service.findAll();
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public UserModel save(@ModelAttribute UserSaveBean bean) throws IOException {
		return this.service.save(bean);
	}

	@PostMapping(path = "/update-user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void update(@ModelAttribute UserUpdateDTO dto) throws IOException {
		this.service.update(dto);
	}

	@GetMapping(path = "/find-friends-by-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> findFriendsByUser(@RequestParam("user") Long userId) {
		return this.service.findFriendsByUser(userId);
	}
}
