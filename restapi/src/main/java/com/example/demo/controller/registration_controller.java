package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.registration;
import com.example.demo.services.registration_service;

@RestController
//to pass data from postman 
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
//angular Connection(front end to back end
public class registration_controller {
	@Autowired
	registration_service serv;
	@PostMapping("/add")
	public registration adding_student(@RequestBody registration reg) {
		return serv.adding_student(reg);
	}
	@PostMapping("/multiadd")
	public Iterable<registration> multi_insertion(@RequestBody List<registration> reg) {
		return serv.multi_insertion(reg);
	}
	@GetMapping("/fetchall")
	public  List<registration> fetch_all() {
		return serv.fetch_all();
	}
	@GetMapping("/fetchbyid/{id}")
	public Optional<registration> fetch_by_id(@PathVariable int id) {
		return serv.find_by_id(id);
	}
	@DeleteMapping("/deletebyid/{id}")
	public String delete_by_id(@PathVariable int id) {
		return serv.delete_by_id(id);
	}
	@GetMapping("/fetchbyemail/{email}")
	public registration fetch_by_email(@PathVariable String email) {
		return serv.find_by_email(email);
	}
	@PutMapping("/update")
	public registration update(@RequestBody registration reg) {
		return serv.update( reg);
	}

}
