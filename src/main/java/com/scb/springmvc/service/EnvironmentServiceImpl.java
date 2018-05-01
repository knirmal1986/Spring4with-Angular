package com.scb.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scb.springmvc.model.Environment;

@Service("EnvironmentService")
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Environment> Environments;
	
	static{
		Environments= populateDummyEnvironments();
	}

	public List<Environment> findAllEnvironments() {
		return Environments;
	}
	
	public Environment findById(long id) {
		for(Environment Environment : Environments){
			if(Environment.getId() == id){
				return Environment;
			}
		}
		return null;
	}
	
	public Environment findByName(String name) {
		for(Environment Environment : Environments){
			if(Environment.getEnv().equalsIgnoreCase(name)){
				return Environment;
			}
		}
		return null;
	}
	
	public void saveEnvironment(Environment Environment) {
		Environment.setId(counter.incrementAndGet());
		Environments.add(Environment);
	}

	public void updateEnvironment(Environment Environment) {
		int index = Environments.indexOf(Environment);
		Environments.set(index, Environment);
	}

	public void deleteEnvironmentById(long id) {
		
		for (Iterator<Environment> iterator = Environments.iterator(); iterator.hasNext(); ) {
		    Environment Environment = iterator.next();
		    if (Environment.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isEnvironmentExist(Environment Environment) {
		return findByName(Environment.getEnv())!=null;
	}
	
	public void deleteAllEnvironments(){
		Environments.clear();
	}

	private static List<Environment> populateDummyEnvironments(){
		List<Environment> Environments = new ArrayList<Environment>();
		Environments.add(new Environment(counter.incrementAndGet(),"url1","CRAMTE_ADF_SIT01","29-4-2018","10-5-2018","FUNDBCA_DEV","ST1"));
		Environments.add(new Environment(counter.incrementAndGet(),"url2","CRAMTE_ADF_DEV01","21-4-2018","10-6-2018","FUNDBCA_DEV_RENG","ST2"));
		Environments.add(new Environment(counter.incrementAndGet(),"url3","CRAMTE_ADF_UAT01","10-4-2018","10-7-2018","DEALID","UAT1"));
		return Environments;
	}

}
