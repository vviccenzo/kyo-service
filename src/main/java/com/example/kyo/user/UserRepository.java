package com.example.kyo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kyo.user.definition.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByName(String name);
}
