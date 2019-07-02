package com.CodePracticeSpring.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CodePracticeSpring.model.userModel;
import com.CodePracticeSpring.repo.userRepo;

@RestController
public class userController {
	
	@Autowired
	private userRepo userrepo;
	
	
		// register new user
		@RequestMapping("/registerUser")
		public ResponseEntity<Object> registerUser(@Valid @RequestBody userModel user) {
			
			userModel Rep = userrepo.save(user);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(Rep.getId()).toUri();

			return ResponseEntity.created(location).build();
	}
		
		
		
}
