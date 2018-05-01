package com.scb.springmvc.service;

import java.util.List;

import com.scb.springmvc.model.Environment;



public interface EnvironmentService {
	
	Environment findById(long id);
	
	Environment findByName(String name);
	
	void saveEnvironment(Environment Environment);
	
	void updateEnvironment(Environment Environment);
	
	void deleteEnvironmentById(long id);

	List<Environment> findAllEnvironments(); 
	
	void deleteAllEnvironments();
	
	public boolean isEnvironmentExist(Environment Environment);
	
}
