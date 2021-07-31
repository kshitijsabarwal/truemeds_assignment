package com.truemeds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.truemeds.model.InputDetails;

@Service
public interface AssignmentService {

	public List<InputDetails> fetchAll();
	
	public boolean processInputs();
	
}
