package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;
import com.example.demo.repo.EmpRepository;
import com.example.demo.repo.LoginRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepo;
	
	@Autowired
	LoginRepository lRepo;
	
	@Autowired
    private JavaMailSender mailSender;
	
    public Boolean authenticate(String username,String password) {
    	if(lRepo.findByUsername(username)!=null) {
    	Login login=lRepo.findByUsername(username);
    	return (username!=null && login.getPassword().equals(password));
    	}
    	else
    		return false;
    }
	
	  public void deleteEmployee(Long id) {
		  empRepo.deleteById(id); }
	 

	public void addEmployee(Employee a) {
		empRepo.save(a);
	}
	public List<Employee> getEmployee(){
		return empRepo.findAll();
		
	}


	public Employee empFindbyId(Long id) {
		return empRepo.findById(id).get();
	}
	 

	    public void sendContactEmail(String name, String email, String phone, String description) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("bprasaddhal44@gmail.com"); // Replace with your email
	        message.setSubject("You’ve Got a New Message from "+name);
	        String emailBody = "You have received a new message from your contact form:\n" +
	                "Name: " + name + "\n" +
	                "Email: " + email + "\n" +
	                "Phone: " + phone + "\n" +
	                "Message:" + description ;

	        message.setText(emailBody);
	        mailSender.send(message);
	    }
}
