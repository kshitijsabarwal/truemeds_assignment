package com.truemeds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="input_details")
public class InputDetails {

	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "input_string")
	String inputString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	
	
}
