package com.scb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class IndexController {

	  @RequestMapping(value="/",method = RequestMethod.GET)
	    public String getIndexPage() {
		    System.out.println("test");
	        return "EnvironmentDetails";
	    }
	  
	  @RequestMapping(value="/list",method = RequestMethod.GET)
	    public String getListPage() {
		    System.out.println("list page");
	        return "EnvironmentDetails";
	    }
	  @RequestMapping(value="/charts",method = RequestMethod.GET)
	    public String getDetailsPage() {
		    System.out.println("charts page");
	        return "EnvrionmentChart";
	    }

}