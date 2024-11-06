package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;
	private String name;
	private Integer age;
	private String gender;
	private String email;
	private String phone;
	private String department;
	private Double salary;
	 /*@Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + empId +
	                ", name='" + name + '\'' +
	                ", age=" + age +
	                ", department='" + department + '\'' +
	                ", email='" + email + '\'' +
	                ", phone='" + phone + '\'' +
	                ", salary=" + salary +
	                ", gender='" + gender + '\'' +
	                '}';*/
		/*
		 * public Long getEmpId() { return empId; } public void setEmpId(Long empId) {
		 * this.empId = empId; } public String getName() { return name; } public void
		 * setName(String name) { this.name = name; } public Integer getAge() { return
		 * age; } public void setAge(Integer age) { this.age = age; } public String
		 * getGender() { return gender; } public void setGender(String gender) {
		 * this.gender = gender; } public String getEmail() { return email; } public
		 * void setEmail(String email) { this.email = email; } public String getPhone()
		 * { return phone; } public void setPhone(String phone) { this.phone = phone; }
		 * public String getDepartment() { return department; } public void
		 * setDepartment(String department) { this.department = department; } public
		 * Double getSalary() { return salary; } public void setSalary(Double salary) {
		 * this.salary = salary; }
		 */
	 }
