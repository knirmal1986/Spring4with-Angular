package com.scb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/partials")
public class MainTemplateController {
	

	@RequestMapping(value="/environmentList",method = RequestMethod.GET)
	    public String getEnvironmentDetailsList() {
	    	return "EnvrionmentChart";	
	    }
	@RequestMapping(value="/environmentDetails",method = RequestMethod.GET)
    public String getEnvironmentDetails() {
    	return "EnvironmentDetails";	
    }
}
