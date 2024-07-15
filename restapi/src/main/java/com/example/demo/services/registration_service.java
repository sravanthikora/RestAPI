package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.registration;
import com.example.demo.repository.registration_repository;

@Service
public class registration_service {
	
	@Autowired
	//connections between any 2 layers
	registration_repository repo;
	//access modifier model name method_name(model_name nickname)
	public registration adding_student(registration reg) {
		return repo.save(reg);
		
	}
	public Iterable<registration> multi_insertion(List<registration> reg){
		return repo.saveAll(reg);
		
	}
	public  List<registration> fetch_all(){
		return (List<registration>) repo.findAll();
	}
	public Optional<registration> find_by_id(int id) {
		return repo.findById(id);
	}
	public String delete_by_id(int id) {
		repo.deleteById(id);
		return "Successfully Deleted "+id;
	}
	public registration find_by_email(String email) {
		return repo.findByEmail(email);
	}
	public registration update(registration reg) {
		int id =reg.getId();
		registration reg1=repo.findById(id).get();
		reg1.setEmail(reg.getEmail());
		reg1.setName(reg.getName());
		reg1.setPassword(reg.getPassword());
		return repo.save(reg1);
	}

}
