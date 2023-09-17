package com.example.kyo.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.example.kyo.user.definition.UserDTO;
import com.example.kyo.user.definition.UserModel;
import com.example.kyo.user.definition.UserSaveBean;
import com.example.kyo.user.definition.UserUpdateDTO;

import io.micrometer.common.util.StringUtils;

public class UserFactory {

	public UserModel buildModel(UserSaveBean bean) throws IOException {
		UserModel model = new UserModel();
		model.setCreatedAt(new Date());
		model.setEmail(bean.getEmail());
		model.setName(bean.getName());
		model.setNickName(bean.getNickName());
		model.setPassword(BCrypt.hashpw(bean.getPassword(), BCrypt.gensalt()));
		model.setLevelPermission(bean.getLevelPermissionType());
		if(StringUtils.isNotBlank(bean.getAvatarPath())) {
			byte[] dadosDaImagem = Files.readAllBytes(new File(bean.getAvatarPath()).toPath());
			model.setAvatar(dadosDaImagem);
		}

		return model;
	}

	public List<UserDTO> buildListBean(List<UserModel> models) {
		return models.stream().map(this::buildDTO).toList();
	}

	public UserDTO buildDTO(UserModel model) {
		UserDTO bean = new UserDTO();
		bean.setCreatedAt(model.getCreatedAt());
		bean.setEmail(model.getEmail());
		bean.setId(model.getId());
		bean.setLevelPermissionType(model.getLevelPermission());
		bean.setName(model.getName());
		bean.setNickName(model.getNickName());

		return bean;
	}

	public void buildModel(UserUpdateDTO dto, UserModel model) throws IOException {
		model.setName(dto.getName());
		model.setNickName(dto.getNickName());
		
		String urlCorrigida = dto.getAvatarPath();

		urlCorrigida = urlCorrigida.replace("\\\\", "/");
		byte[] dadosDaImagem = Files.readAllBytes(new File(urlCorrigida).toPath());
		model.setAvatar(dadosDaImagem);
	}
}
