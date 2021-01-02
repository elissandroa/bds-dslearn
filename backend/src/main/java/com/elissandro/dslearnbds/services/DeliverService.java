package com.elissandro.dslearnbds.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elissandro.dslearnbds.dto.DeliverRevisionDTO;
import com.elissandro.dslearnbds.entities.Deliver;
import com.elissandro.dslearnbds.observers.DeliverRevisionObserver;
import com.elissandro.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {
		@Autowired
		DeliverRepository repository;
		
		private Set<DeliverRevisionObserver> deliverRevisionObservers = new LinkedHashSet<>();
		@Transactional
		public void saveRevision(Long id, DeliverRevisionDTO dto) {
			Deliver deliver = repository.getOne(id);
			deliver.setStatus(dto.getStatus());
			deliver.setFeedback(dto.getFeedback());
			deliver.setCorrectCount(dto.getCorrectCount());
			repository.save(deliver);
			for(DeliverRevisionObserver observer: deliverRevisionObservers) {
				observer.onSaveReVision(deliver);
			}
		}
		
		public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer) {
			deliverRevisionObservers.add(observer);
		}
}
