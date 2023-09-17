package com.example.kyo.user;

import java.io.IOException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kyo.user.definition.UserDTO;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.definition.UserSaveBean;
import com.example.kyo.user.definition.UserUpdateDTO;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	private UserFactory factory = new UserFactory();

	public List<UserDTO> findAll() {
		return new UserFactory().buildListBean(this.repository.findAll());
	}

	@Transactional
	public UserModel save(UserSaveBean bean) throws IOException {
		return this.repository.save(this.factory.buildModel(bean));
	}

	public UserModel findById(Long id) {
		return this.repository.findById(id).get();
	}

	public UserModel findByName(String name) {
		return this.repository.findByName(name);
	}

	@Transactional
	public void update(UserUpdateDTO dto) throws IOException {
		UserModel model =  this.findById(dto.getUserId());
		this.factory.buildModel(dto, model);

		this.repository.save(model);
	}

	public UserDTO findByEmailAndPassword(String email, String password) {
		UserModel model = this.repository.findByEmail(email);
		boolean isValid = BCrypt.checkpw(password, model.getPassword());
		if(isValid) {
			return this.factory.buildDTO(model);
		}

		throw new RuntimeException("User is not valid");
	}
}
