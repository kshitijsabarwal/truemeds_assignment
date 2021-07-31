package com.truemeds.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truemeds.model.InputDetails;
import com.truemeds.model.OutputDetails;
import com.truemeds.repository.InputDetailsRepository;
import com.truemeds.repository.OutputDetailsRepository;
import com.truemeds.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	int count = 0;

	final static String myName = "Kshitij_Sabarwal";

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	private static final Logger log = LogManager.getLogger(AssignmentServiceImpl.class);

	@Autowired 
	InputDetailsRepository inputDetailsRepository;

	@Autowired
	OutputDetailsRepository outPutDetailsRepository;

	@Override 
	public List<InputDetails> fetchAll() { 
		log.info("In AssignmentServiceImpl :: fetchAll");
		return inputDetailsRepository.findAll(); 
	}

	@Override
	public boolean processInputs() {

		log.info("In AssignmentServiceImpl :: processInputs");
		List<InputDetails> inputDetails = inputDetailsRepository.findAll();

		try {
			for(InputDetails inputDetail : inputDetails){

				count=0;
				OutputDetails outPutDetails = new OutputDetails();

				String stringToProcess = inputDetail.getInputString();
				String finalString = remove(stringToProcess);
				outPutDetails.setFinalOutput(finalString);
				outPutDetails.setCount(count);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				outPutDetails.setNameAndTs(myName+"_"+timestamp);
				outPutDetailsRepository.save(outPutDetails);

			}
			return true;
		}

		catch(Exception e){
			log.error("Unable to process/save data " + e.getMessage());
			return false;
		}

	}

	private String remove(String str) 
	{
		char lastRemoved = '\0';
		return removeDuplicates(str, lastRemoved, count);      
	}

	private String removeDuplicates(String currentString, char lastRemoved, int steps) {

		if(currentString.contains(" ")) {
			count++;
			currentString = currentString.replaceAll("\\s", "");
		}

		if (currentString.length() == 0 || currentString.length() == 1)
			return currentString;

		if (currentString.charAt(0) == currentString.charAt(1))
		{
			lastRemoved = currentString.charAt(0);

			while (currentString.length() > 1 && currentString.charAt(0) == currentString.charAt(1)) {
				count++;
				currentString = currentString.substring(1, currentString.length());
			}
			currentString = currentString.substring(1, currentString.length());
			return removeDuplicates(currentString, lastRemoved,count);
		}

		String remainingString = removeDuplicates(currentString.substring(
				1,currentString.length()), lastRemoved,count);

		if (remainingString.length() != 0 && remainingString.charAt(0) == currentString.charAt(0))
		{
			lastRemoved = currentString.charAt(0);
			return remainingString.substring(1,remainingString.length());
		}

		if (remainingString.length() == 0 && lastRemoved == currentString.charAt(0))
			return remainingString;

		return (currentString.charAt(0) + remainingString);
	}

}
