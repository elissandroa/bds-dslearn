package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elissandro.dslearnbds.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
