package com.scb.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.scb.springmvc.model.Environment;
import com.scb.springmvc.service.EnvironmentService;
 
@RestController
public class EnvironmentRestController {
 
    @Autowired
    EnvironmentService EnvironmentService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Environments--------------------------------------------------------
     
    @RequestMapping(value = "/Environment", method = RequestMethod.GET)
    public ResponseEntity<List<Environment>> listAllEnvironments() {
        List<Environment> Environments = EnvironmentService.findAllEnvironments();
        if(Environments.isEmpty()){
            return new ResponseEntity<List<Environment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Environment>>(Environments, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Environment--------------------------------------------------------
     
    @RequestMapping(value = "/Environment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Environment> getEnvironment(@PathVariable("id") long id) {
        System.out.println("Fetching Environment with id " + id);
        Environment Environment = EnvironmentService.findById(id);
        if (Environment == null) {
            System.out.println("Environment with id " + id + " not found");
            return new ResponseEntity<Environment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Environment>(Environment, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Environment--------------------------------------------------------
     
    @RequestMapping(value = "/Environment", method = RequestMethod.POST)
    public ResponseEntity<Void> createEnvironment(@RequestBody Environment Environment,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Environment " + Environment.getEnv());
 
        if (EnvironmentService.isEnvironmentExist(Environment)) {
            System.out.println("A Environment with name " + Environment.getEnv() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        EnvironmentService.saveEnvironment(Environment);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Environment/{id}").buildAndExpand(Environment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Environment --------------------------------------------------------
     
    @RequestMapping(value = "/Environment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Environment> updateEnvironment(@PathVariable("id") long id, @RequestBody Environment Environment) {
        System.out.println("Updating Environment " + id);
         
        Environment currentEnvironment = EnvironmentService.findById(id);
         
        if (currentEnvironment==null) {
            System.out.println("Environment with id " + id + " not found");
            return new ResponseEntity<Environment>(HttpStatus.NOT_FOUND);
        }
 
        currentEnvironment.setUrl(Environment.getUrl());
        currentEnvironment.setEndDate(Environment.getEndDate());
        currentEnvironment.setStartDate(Environment.getStartDate());
        currentEnvironment.setEnv(Environment.getEnv());
        currentEnvironment.setProjectName(Environment.getProjectName());
        currentEnvironment.setId(id);
        currentEnvironment.setSchema(Environment.getSchema());
         
        EnvironmentService.updateEnvironment(currentEnvironment);
        return new ResponseEntity<Environment>(currentEnvironment, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Environment --------------------------------------------------------
     
    @RequestMapping(value = "/Environment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Environment> deleteEnvironment(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Environment with id " + id);
 
        Environment Environment = EnvironmentService.findById(id);
        if (Environment == null) {
            System.out.println("Unable to delete. Environment with id " + id + " not found");
            return new ResponseEntity<Environment>(HttpStatus.NOT_FOUND);
        }
 
        EnvironmentService.deleteEnvironmentById(id);
        return new ResponseEntity<Environment>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Environments --------------------------------------------------------
     
    @RequestMapping(value = "/Environment", method = RequestMethod.DELETE)
    public ResponseEntity<Environment> deleteAllEnvironments() {
        System.out.println("Deleting All Environments");
 
        EnvironmentService.deleteAllEnvironments();
        return new ResponseEntity<Environment>(HttpStatus.NO_CONTENT);
    }
 
}