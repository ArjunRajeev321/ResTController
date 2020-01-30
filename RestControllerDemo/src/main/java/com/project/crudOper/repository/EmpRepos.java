package com.project.crudOper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crudOper.Models.Employee;

public interface EmpRepos extends JpaRepository<Employee, Integer>{

}
