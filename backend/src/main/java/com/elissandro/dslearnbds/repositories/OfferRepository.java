package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elissandro.dslearnbds.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
