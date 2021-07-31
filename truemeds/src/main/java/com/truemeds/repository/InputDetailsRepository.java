package com.truemeds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truemeds.model.InputDetails;

@Repository
public interface InputDetailsRepository extends JpaRepository<InputDetails, Integer> {
	
}
