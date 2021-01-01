package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
