package com.project.crudOper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudOper.Models.Employee;
import com.project.crudOper.repository.EmpRepos;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpRestController {

	@Autowired
	private EmpRepos repos;

	
	@GetMapping("/emp")
	public List<Employee> openIndex() {
		
		List<Employee> lst = new ArrayList<Employee>();
		lst = repos.findAll();
		
		return lst;

	}
	
	@PostMapping("/empl")
	public boolean Insert(@RequestBody Employee emp) {
		try {
			repos.save(emp);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
		return true;

	}
	
	@DeleteMapping("/emp/{id}")
	public boolean delEmp(@PathVariable("id") int id) {
		try {
			repos.deleteById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;

	}
	
	@PutMapping("/emp/{id}")
	public boolean updEmp(@PathVariable("id") int id,@RequestBody Employee emp) {
		try {
			emp.setId(id);
			repos.save(emp);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;

	}
	

}
