package com.example.kyo.message;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.kyo.message.definition.MessageSendBean;
import com.example.kyo.message.definition.MessageAudioBean;
import com.example.kyo.message.definition.MessageBean;
import com.example.kyo.message.definition.MessageModel;
import com.example.kyo.user.definition.UserModel;

import io.micrometer.common.util.StringUtils;

public class MessageFactory {

	public MessageModel buildModel(MessageSendBean bean, UserModel target, UserModel user) {
		return new MessageModel(bean.getMessage(), user, target, new Date());
	}

	public MessageModel buildModelWithImage(MessageSendBean bean, UserModel target, UserModel user) throws IOException {
		MessageModel model = new MessageModel();
		if(StringUtils.isNotBlank(bean.getMessage())) {
			model.setMessage(bean.getMessage());
		}

		if(bean.getImage().getBytes().length > 0) {
			model.setImage(bean.getImage().getBytes());
		}

		model.setTarget(target);
		model.setUser(user);

		return model;
	}

	public MessageModel buildBeanWithAudio(MessageAudioBean bean, UserModel user, UserModel target) throws IOException {
		MessageModel model = new MessageModel();
		model.setTarget(target);
		model.setUser(user);

		if(bean.getAudio().getBytes().length > 0) {
			model.setAudio(bean.getAudio().getBytes());
		}

		return model;
	}

	public MessageBean buildBean(MessageModel model) {
		MessageBean bean = new MessageBean();
		bean.setMessage(model.getMessage());
		bean.setId(model.getId());
		bean.setTargetId(model.getTarget().getId());
		bean.setUserId(model.getUser().getId());
		bean.setCreatedAt(model.getCreatedAt());

		if(model.getReceivedDate() != null) {
			bean.setReceivedDate(model.getReceivedDate());
		}

		if(model.getImage().length > 0) {
			bean.setImage(model.getImage());
		}

		if(model.getAudio().length > 0) {
			bean.setAudio(model.getAudio());
		}

		return bean;
	}

	public List<MessageBean> buildListBean(List<MessageModel> models) {
		return models.stream().map(model -> this.buildBean(model)).collect(Collectors.toList());
	}
}
 