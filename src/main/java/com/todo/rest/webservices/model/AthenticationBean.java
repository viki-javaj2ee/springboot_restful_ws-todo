package com.todo.rest.webservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AthenticationBean {

	private String message;

	public AthenticationBean(String message) {
		this.message = message;
	}	
}
