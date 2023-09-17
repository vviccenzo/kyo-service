package com.example.kyo.post.like;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.post.like.definition.LikeModel;

public interface LikeRepository extends JpaRepository<LikeModel, Long>{

}
