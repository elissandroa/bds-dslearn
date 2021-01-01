package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.Enrollment;
import com.elissandro.dslearnbds.entities.pk.EnrollmentPK;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK>{

}
