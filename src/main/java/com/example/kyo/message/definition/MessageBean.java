package com.example.kyo.message.definition;

import java.util.Date;

import com.example.kyo.generic.definition.GenericDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBean extends GenericDTO {

	private String message;
	private Long userId;
	private Long targetId;
	private Date receivedDate;
	private Date createdAt;
	private byte[] image;
	private byte[] audio;
}