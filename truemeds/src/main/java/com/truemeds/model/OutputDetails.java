package com.truemeds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kshitij_sabarwal_java_output_updated_final")
public class OutputDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "final_output")
	String finalOutput;
	
	@Column(name = "count")
	int count;
	
	@Column(name = "name_timestamp")
	String nameAndTs;

	public String getFinalOutput() {
		return finalOutput;
	}

	public void setFinalOutput(String finalOutput) {
		this.finalOutput = finalOutput;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNameAndTs() {
		return nameAndTs;
	}

	public void setNameAndTs(String nameAndTs) {
		this.nameAndTs = nameAndTs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
