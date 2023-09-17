package com.example.kyo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kyo.user.definition.UserDTO;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.definition.UserSaveBean;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		return new UserFactory().buildListBean(this.repository.findAll());
	}

	@Transactional
	public UserModel save(UserSaveBean bean) {
		return this.repository.save(new UserFactory().buildModel(bean));
	}

	public UserModel findById(Long id) {
		return this.repository.findById(id).get();
	}

	public UserModel findByName(String name) {
		return this.repository.findByName(name);
	}
}
