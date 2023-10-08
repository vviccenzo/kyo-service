package com.example.kyo.notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kyo.notification.definition.NotificationModel;

public interface NotificationRepository extends JpaRepository<NotificationModel, Long>{

	List<NotificationModel> findAllById(Long userId);

}
