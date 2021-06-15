package com.example.HelloHuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	
	
	@RequestMapping("")
	public String human() {
		return "Hello Human!";
		
	}
	
	
	@RequestMapping("{first_name}")
	public String firstName(@PathVariable("first_name") String Fname) {
		return "Hello "+Fname+"!";
		
	}
	
	@RequestMapping("{first_name}/{last_name}")
	public String name(@PathVariable("first_name") String Fname,@PathVariable("last_name") String Lname ) {
		return "Hello "+Fname+" "+Lname+"!";
		
	}

	
}
