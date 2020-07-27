package com.todo.rest.webservices.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class TodoBean {
	
	private long id;
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

}
