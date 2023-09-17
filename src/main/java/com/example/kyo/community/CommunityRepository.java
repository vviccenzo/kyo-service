package com.example.kyo.community;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.community.definition.CommunityModel;

public interface CommunityRepository extends JpaRepository<CommunityModel, Long>{
}
