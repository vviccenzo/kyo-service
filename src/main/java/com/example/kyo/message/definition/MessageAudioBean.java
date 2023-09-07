package com.example.kyo.message.definition;

import org.springframework.web.multipart.MultipartFile;

import com.example.kyo.generic.definition.GenericBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MessageAudioBean extends GenericBean {

	private Long userId;
	private Long targetId;
	private MultipartFile audio;
}
