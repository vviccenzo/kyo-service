package com.example.kyo.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kyo.message.definition.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {

	@Query("SELECT m FROM MessageModel m WHERE m.user.id = :userId OR m.target.id = :userId AND m.user.id = :targetId OR m.target.id = :targetId")
	List<MessageModel> findAllByConversation(Long userId, Long targetId);
}

