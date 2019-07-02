package com.CodePracticeSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class crudmodel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
    @Size(min=2, max=30)
	private String name;
	
	@NotNull
    @Size(min=2, max=30)
	private String surname;
	
	@NotNull
   // @Size(min=2, max=30)
	private String pic;
	
	@NotNull
    @Size(min=2, max=150)
	private String bio;
	
	@NotNull
    @Size(min=2, max=30)
	private String role;
	
	@NotNull
    @Size(min=1, max=10)
	private String gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public crudmodel(int id, String name, String surname, String pic, String bio, String role, String gender) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pic = pic;
		this.bio = bio;
		this.role = role;
		this.gender = gender;
	}
	public crudmodel() {
	}
	
	
	
		
}
