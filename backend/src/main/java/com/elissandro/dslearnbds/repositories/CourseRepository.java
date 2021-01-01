package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elissandro.dslearnbds.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
