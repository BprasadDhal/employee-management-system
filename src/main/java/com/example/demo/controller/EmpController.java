package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	
	@Autowired
	EmpService empServ;
	
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	@PostMapping("save")
	public String saveEmp(@ModelAttribute Employee a,HttpSession session) {
		if(session.getAttribute("loggedIn")!=null) {
		empServ.addEmployee(a);
		return "redirect:/adminView";
		}
		return "/";
	}
	@GetMapping("adminView")
	public ModelAndView adminViewEmp(HttpSession session) {
		if(session.getAttribute("loggedIn")!=null) {
		List<Employee> l=empServ.getEmployee();
		return new ModelAndView("adminViewEmp","Emp",l);
		}
		return new ModelAndView("redirect:/");
	}
	@GetMapping("view")
	public ModelAndView viewEmp() { 
		List<Employee> list=empServ.getEmployee();
		return new ModelAndView("viewEmp","employee",list);
	}
	
	@GetMapping("addEmp")
	public String addEmp(HttpSession session) {
	if((session.getAttribute("loggedIn"))!=null) {
		return "addEmp"; 
	}else {
			return "redirect:/";
	}
	}
	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable Long id) {
		empServ.deleteEmployee(id); 
		return "redirect:/adminView";
	}
	@RequestMapping("/editEmp/{id}")
	public String editEmp(@PathVariable Long id,Model m,HttpSession session) {
		if(session.getAttribute("loggedIn")!=null) {
		Employee e=empServ.empFindbyId(id);
		m.addAttribute("edit",e);
		return "editEmp"; 
		}
		return "/";
		}
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs"; 
	}
	 @PostMapping("/contact")
	    public String submitContact(
	            @RequestParam("name") String name,
	            @RequestParam("email") String email,
	            @RequestParam("phone") String phone, 
	            @RequestParam("description") String description) {
	        

	        empServ.sendContactEmail(name, email, phone, description);
	        return"submitted";
	 }
	 @PostMapping("/login")
	 public String login(@RequestParam("username") String username,@RequestParam("password")String password,HttpSession session) {
		if(empServ.authenticate(username, password)){
	    session.setAttribute("loggedIn", username);
		
		 return"manage"; 
	 }
		return"redirect:/";
		}
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	     session.invalidate();
	     return "redirect:/";
	 }

}
