package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee,Long>{

}
