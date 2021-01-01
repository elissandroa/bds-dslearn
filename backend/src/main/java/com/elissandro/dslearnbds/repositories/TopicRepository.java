package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
