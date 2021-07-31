package com.truemeds.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truemeds.model.ResponseDef;
import com.truemeds.service.AssignmentService;

@RestController
@RequestMapping(value = "/truemeds")
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	private static final Logger log = LogManager.getLogger(AssignmentController.class);
	
	@PostMapping(value = "/processInputs")
	public ResponseEntity<ResponseDef> processInputs() {
		
		log.info("In AssignmentController :: processInputs");
		ResponseDef responseDef = new ResponseDef();
		boolean success = assignmentService.processInputs();
		if(success) {
			responseDef.setMessage("All inputs processed successfully");
			responseDef.setStatusCode(HttpStatus.ACCEPTED);
			return new ResponseEntity<ResponseDef>(responseDef,HttpStatus.ACCEPTED);
		}
		else {
			responseDef.setMessage("Unable to process");
			responseDef.setStatusCode(HttpStatus.EXPECTATION_FAILED);
			return new ResponseEntity<ResponseDef>(responseDef,HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
