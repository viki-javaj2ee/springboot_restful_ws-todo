package com.todo.rest.webservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.rest.webservices.model.AthenticationBean;
import com.todo.rest.webservices.model.HelloWorldBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	
	@RequestMapping(method=RequestMethod.GET, path="/basicauth")
	public AthenticationBean basicAuthentication() {
		return new AthenticationBean("You are authenticated");
	}

}
