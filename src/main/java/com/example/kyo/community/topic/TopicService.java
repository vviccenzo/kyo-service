package com.example.kyo.community.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kyo.community.topic.definition.TopicModel;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public TopicModel getById(Long id) {
		return this.topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic: " + id + " not found."));
	}
}
