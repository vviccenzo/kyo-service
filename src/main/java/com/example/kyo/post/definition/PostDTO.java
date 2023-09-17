package com.example.kyo.post.definition;

import java.util.Date;

import com.example.kyo.community.definition.CommunityDTO;
import com.example.kyo.user.definition.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

	private Long id;
	private String content;
	private UserDTO author;
	private CommunityDTO community;
	private Date createdAt;
}
