package com.elissandro.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elissandro.dslearnbds.dto.DeliverRevisionDTO;
import com.elissandro.dslearnbds.entities.Deliver;
import com.elissandro.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {
		@Autowired
		DeliverRepository repository;
		
		@Transactional
		public void saveRevision(Long id, DeliverRevisionDTO dto) {
			Deliver deliver = repository.getOne(id);
			deliver.setStatus(dto.getStatus());
			deliver.setFeedback(dto.getFeedback());
			deliver.setCorrectCount(dto.getCorrectCount());
			repository.save(deliver);
		}
}
