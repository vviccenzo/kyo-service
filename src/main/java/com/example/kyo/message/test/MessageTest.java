package com.example.kyo.message.test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import com.example.kyo.message.definition.MessageModel;
import io.micrometer.common.util.StringUtils;

import static org.junit.Assert.assertTrue;

public class MessageTest {

	@Test
	public void testCreatingMessageWithoutAnyMedia() {
		MessageModel model = MessageMock.createMockWithoutMedia();
		boolean isCreated = this.validateFieldsWithoutAnyMedia(model);

		assertTrue(isCreated);
	}

	@Test
	public void testCreatingMessageWithImage() {
		MessageModel model = MessageMock.createMockWithImage();
		boolean isCreated = this.validateFieldsWithImage(model);

		assertTrue(isCreated);
	}

	@Test
	public void testCreatingMessageWithAudio() {
		MessageModel model = MessageMock.createMockWithAudio();
		boolean isCreated = this.validateFieldsWithAudio(model);

		assertTrue(isCreated);
	}

	private boolean validateFieldsWithoutAnyMedia(MessageModel message) {
		return 
				StringUtils.isNotBlank(message.getMessage()) 
				&& message.getId() != null 
				&& message.getUser() != null
				&& message.getTarget() != null 
				&& message.getCreatedAt() != null;
	}

	private boolean validateFieldsWithImage(MessageModel message) {
		return 
				StringUtils.isNotBlank(message.getMessage()) 
				&& message.getId() != null 
				&& message.getUser() != null
				&& message.getTarget() != null 
				&& message.getCreatedAt() != null 
				&& message.getImage().length > 0;
	}

	private boolean validateFieldsWithAudio(MessageModel message) {
		return 
				StringUtils.isNotBlank(message.getMessage()) 
				&& message.getId() != null 
				&& message.getUser() != null
				&& message.getTarget() != null 
				&& message.getCreatedAt() != null 
				&& message.getAudio().length > 0;
	}
}

