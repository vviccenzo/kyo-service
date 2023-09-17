package com.example.kyo.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.post.definition.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Long> {

	List<PostModel> findAllById(Long userId);

	List<PostModel> findAllByUserId(Long userId);
}
