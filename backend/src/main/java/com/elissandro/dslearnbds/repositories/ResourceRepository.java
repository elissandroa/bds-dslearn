package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
