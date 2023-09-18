package com.example.kyo.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.kyo.post.definition.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Long> {

	List<PostModel> findAllById(Long userId);

	@Query("SELECT p FROM PostModel p where p.user.id = :userId ORDER BY p.createdAt DESC")
	List<PostModel> findAllByUserId(Long userId);
}
