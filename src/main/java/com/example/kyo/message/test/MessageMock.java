package com.example.kyo.message.test;

import java.util.Date;

import com.example.kyo.message.definition.MessageModel;
import com.example.kyo.user.test.UserMock;

public class MessageMock {

	public static MessageModel createMock() {
		MessageModel mock = new MessageModel();

		mock.setId(1L);
		mock.setMessage("Test message");
		mock.setUser(UserMock.createMock());
		mock.setTarget(UserMock.createMock());
		mock.setReceivedDate(new Date());
		mock.setCreatedAt(new Date());
		mock.setImage(new byte[0]);
		mock.setAudio(new byte[0]);

		return mock;
	}

	public static MessageModel createMockWithCustomMessage(String message) {
		MessageModel mock = createMock();
		mock.setMessage(message);
		return mock;
	}

	public static MessageModel createMockWithImage() {
		MessageModel mock = new MessageModel();

		mock.setId(1L);
		mock.setMessage("Test message");
		mock.setUser(UserMock.createMock());
		mock.setTarget(UserMock.createMock());
		mock.setReceivedDate(new Date());
		mock.setCreatedAt(new Date());
		mock.setImage(new byte[0]);

		return mock;
	}
	
	public static MessageModel createMockWithAudio() {
		MessageModel mock = new MessageModel();

		mock.setId(1L);
		mock.setMessage("Test message");
		mock.setUser(UserMock.createMock());
		mock.setTarget(UserMock.createMock());
		mock.setReceivedDate(new Date());
		mock.setCreatedAt(new Date());
		mock.setAudio(new byte[0]);

		return mock;
	}

	public static MessageModel createMockWithoutMedia() {
		MessageModel mock = new MessageModel();

		mock.setId(1L);
		mock.setMessage("Test message");
		mock.setUser(UserMock.createMock());
		mock.setTarget(UserMock.createMock());
		mock.setReceivedDate(new Date());
		mock.setCreatedAt(new Date());

		return mock;
	}
}
