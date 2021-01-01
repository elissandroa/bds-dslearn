package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
