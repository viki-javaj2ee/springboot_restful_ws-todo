package com.todo.rest.webservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.rest.webservices.model.HelloWorldBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World !!!";
	}

	@RequestMapping(method=RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean Message !!!");
	}

	@RequestMapping(method=RequestMethod.GET, path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPAthVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,  %s",name));
	}
}
