package com.example.kyo.community.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.community.topic.definition.TopicModel;

public interface TopicRepository extends JpaRepository<TopicModel, Long>{

}
