package com.todo.rest.webservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todo.rest.webservices.model.TodoBean;
import com.todo.rest.webservices.service.TodoHardcodedService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoHardcodedService todoService;

	@RequestMapping(method=RequestMethod.GET, path="/users/{username}/todos")
	public List<TodoBean> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}

	@RequestMapping(method=RequestMethod.GET, path="/users/{username}/todos/{id}")
	public TodoBean getTodo(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		 TodoBean todo = todoService.deleteById(id);
		 
		 if(todo != null) {
			 return ResponseEntity.noContent().build();
		 }
		 
		 return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/users/{username}/todos/{id}")
	public ResponseEntity<TodoBean> updateTodo(
			@PathVariable String username, 
			@PathVariable long id,
			@RequestBody TodoBean todo){
		
		TodoBean todoUpdated = todoService.save(todo);
		    
		return new ResponseEntity<TodoBean>(todo, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, path="/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(
			@PathVariable String username, 
			@RequestBody TodoBean todo){
		
		TodoBean createdTodo = todoService.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(createdTodo.getId())
			.toUri();
		    
		return ResponseEntity.created(uri).build();
	}


}
