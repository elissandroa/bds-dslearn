package com.elissandro.dslearnbds.services;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elissandro.dslearnbds.dto.NotificationDTO;
import com.elissandro.dslearnbds.entities.Deliver;
import com.elissandro.dslearnbds.entities.Notification;
import com.elissandro.dslearnbds.entities.User;
import com.elissandro.dslearnbds.observers.DeliverRevisionObserver;
import com.elissandro.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService implements DeliverRevisionObserver {

		@Autowired
		private NotificationRepository repository;
		
		@Autowired
		private AuthService authService;
		
		@Autowired
		private DeliverService deliverService;
		
		@PostConstruct
		private void initialize() {
			deliverService.subscribeDeliverRevisionObserver(this);
		}
		
		@Transactional(readOnly = true)
		public Page<NotificationDTO> notificationsForCurrentUser(boolean unReadOnly, Pageable pageable){
			User user = authService.authenticated();
			Page<Notification> page = repository.find(user, unReadOnly, pageable);
			return page.map(x -> new NotificationDTO(x));
		}
		
		@Transactional
		public void saveDeliverNotification(Deliver deliver) {
			Long sectionId = deliver.getLesson().getSection().getId();
			Long resourceId = deliver.getLesson().getSection().getResource().getId();
			Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();
			
			String route = "/offers" + offerId + "/resources/" + resourceId + "/sections/" + sectionId;
			String text = deliver.getFeedback();
			Instant moment = Instant.now();
			User user = deliver.getEnrollment().getStudent();
			
			Notification notification = new Notification(null, text, moment, false, route, user);
			repository.save(notification);
		}

		@Override
		public void onSaveReVision(Deliver deliver) {
			saveDeliverNotification(deliver);
			
		}
		
		
}
