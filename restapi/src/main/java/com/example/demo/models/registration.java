package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//generating getters and setters

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class registration {
	//creating column names
	@Id
	//starting point for creating columns
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//for auto increment of id
	private String name;
	@Email
	@Size(max = 40,min = 5)
	private String email;
	
	private String password;
	
	
	

}
