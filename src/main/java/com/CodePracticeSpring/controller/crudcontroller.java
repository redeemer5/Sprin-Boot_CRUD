package com.CodePracticeSpring.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CodePracticeSpring.model.crudmodel;
import com.CodePracticeSpring.repo.crudRepo;

//import com.example.demo.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

public class crudcontroller {
	
	@Autowired
	private crudRepo repo;
	
	
	// get method
	
	@RequestMapping("/getAll")
	public List<crudmodel> retrieveAllStudents() {
		return repo.findAll();
	}


	// post method
	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody crudmodel user) {
		
		crudmodel Rep = repo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(Rep.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	// find user by id
	
	@RequestMapping("/userOne/{id}")
	public crudmodel retrieveUser(@PathVariable int id) throws Exception {
		Optional<crudmodel> user = repo.findById(id);

		if (!user.isPresent())
			throw new Exception("id-" + id);

		return user.get();
	}
	
	
	// delete user
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
	public void deleteuser(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	// update record
	
	@RequestMapping(method = RequestMethod.PUT, value = "/userUpdate/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody crudmodel user, @PathVariable int id) {

		Optional<crudmodel> userfound = repo.findById(id);

		if (!userfound.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		repo.save(user);

		return ResponseEntity.noContent().build();
	}
}
