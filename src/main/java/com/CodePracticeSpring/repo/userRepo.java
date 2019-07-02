package com.CodePracticeSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodePracticeSpring.model.userModel;

public interface userRepo extends JpaRepository<userModel,Integer> {

}
