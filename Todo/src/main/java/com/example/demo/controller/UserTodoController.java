package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserTodo;
import com.example.demo.service.UserTodoService;


@RestController
	public class UserTodoController {
	 
	private final UserTodoService userService;

    @Autowired
    public UserTodoController(UserTodoService userService) {
        this.userService = userService;
    }
	        
	    @GetMapping("/todo")
	    public List<UserTodo> findAllUsers() {
			return userService.getAllUsersTodo();
	       
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<UserTodo> findUserById(@PathVariable(value = "id") long id) {
	    	 Optional<UserTodo> user = userService.getUserTodoById(id);
	    			
	    	 
	    	    if(user.isPresent()) {
	    	        return ResponseEntity.ok().body(user.get());
	    	    } else {
	    	        return ResponseEntity.notFound().build();
	    	    }
	    	}
	    
	 
	    @PostMapping("/userTodo")
	    public UserTodo saveUser(@Validated @RequestBody UserTodo user) {
	    	return userService.createUserTodo(user);
	    }
	}


