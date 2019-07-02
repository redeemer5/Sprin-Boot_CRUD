package com.CodePracticeSpring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.CodePracticeSpring.model.crudmodel;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public interface crudRepo extends JpaRepository<crudmodel,Integer> {
	
//	@Query(value = "select user.name from user",nativeQuery=true)
//	List<crudmodel> retrieveUser();	
}
