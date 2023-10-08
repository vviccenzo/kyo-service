package com.example.kyo.user.friendRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.user.friendRequest.definition.FriendRequestModel;

public interface FriendRequestRepository extends JpaRepository<FriendRequestModel, Long>{

	public List<FriendRequestModel> findAllByReceiverId(Long userId);

	public FriendRequestModel findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
