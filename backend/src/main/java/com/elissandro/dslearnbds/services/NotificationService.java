package com.elissandro.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elissandro.dslearnbds.dto.NotificationDTO;
import com.elissandro.dslearnbds.entities.Notification;
import com.elissandro.dslearnbds.entities.User;
import com.elissandro.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

		@Autowired
		private NotificationRepository repository;
		
		@Autowired
		private AuthService authService;
		
		public Page<NotificationDTO> notificationsForCurrentUser(boolean unReadOnly, Pageable pageable){
			User user = authService.authenticated();
			Page<Notification> page = repository.find(user, unReadOnly, pageable);
			return page.map(x -> new NotificationDTO(x));
		}
		
		
}
