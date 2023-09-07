package com.example.kyo.message;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kyo.message.definition.MessageSendBean;
import com.example.kyo.message.definition.MessageAudioBean;
import com.example.kyo.message.definition.MessageBean;
import com.example.kyo.message.definition.MessageModel;
import com.example.kyo.user.UserService;
import com.example.kyo.user.definition.UserModel;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repository;

	@Autowired
	private UserService userService;

	@Transactional
	public MessageBean sendMessage(MessageSendBean bean) throws IOException {
		UserModel user = this.userService.findById(bean.getUserId());
		UserModel target = 	this.userService.findById(bean.getTargetId());

		MessageModel message = null;
		if(bean.getImage() != null) {
			message = this.repository.save(new MessageFactory().buildModelWithImage(bean, target, user));
		} else {
			message = this.repository.save(new MessageFactory().buildModel(bean, target, user));
		}

		return new MessageFactory().buildBean(message);
	}

	public List<MessageBean> findAllByConversation(Long userId, Long targetId) {
		return new MessageFactory().buildListBean(this.repository.findAllByConversation(userId, targetId));
	}

	@Transactional
	public MessageBean receiveMessage(Long id) {
		Optional<MessageModel> model = this.repository.findById(id);
		if(model.isPresent()) {
			MessageModel receiveMessaged = model.get();
			receiveMessaged.setReceivedDate(new Date());

			return new MessageFactory().buildBean(this.repository.save(receiveMessaged));
		} else {
			throw new RuntimeException("Message not founded.");
		}
	}

	@Transactional
	public MessageBean sendMessageAudio(MessageAudioBean bean) throws IOException {
		UserModel user = this.userService.findById(bean.getUserId());
		UserModel target = 	this.userService.findById(bean.getTargetId());

		return new MessageFactory().buildBean(this.repository.save(new MessageFactory().buildBeanWithAudio(bean, user, target)));
	}
}
