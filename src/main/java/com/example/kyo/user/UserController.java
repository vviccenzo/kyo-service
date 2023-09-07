package com.example.kyo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.user.definition.UserBean;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.definition.UserSaveBean;

@RestController
@RequestMapping(path = "/kyo/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	private List<UserBean> findAll() {
		return this.service.findAll();
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	private UserModel save(@ModelAttribute UserSaveBean bean) {
	    return this.service.save(bean);
	}

}
