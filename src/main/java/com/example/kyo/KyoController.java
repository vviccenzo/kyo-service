package com.example.kyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyo.definition.KyoLoginDTO;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserDTO;

@RestController
@RequestMapping("/kyo")
public class KyoController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/login", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public UserDTO doLogin(@ModelAttribute KyoLoginDTO dto) {
		return this.userService.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
	}
}
