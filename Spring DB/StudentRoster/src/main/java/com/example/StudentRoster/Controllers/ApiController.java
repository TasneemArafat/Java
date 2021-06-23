package com.example.StudentRoster.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.StudentRoster.Service.ApiService;
import com.example.StudentRoster.models.Contact;
import com.example.StudentRoster.models.Students;

@Controller
public class ApiController {
	
	private final ApiService apiService;

	public ApiController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	
	@RequestMapping("/students")
	public String main(Model model) {
		model.addAttribute("students",apiService.findAllStudents());
		return "index.jsp";
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Students student) {
		return "newStudent.jsp";
	}
	
	@RequestMapping(value= "/students/new", method=RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Students student, BindingResult result) {
		if(result.hasErrors()) {
			return "newStudent.jsp";
		}
			apiService.createStudent(student);
			return "redirect:/students";
	}
	
	@RequestMapping("/contacts/new")
	public String newStudent(@ModelAttribute("contact") Contact contact, Model model) {
		model.addAttribute("stu",apiService.findNoAddressStudents());
		return "newContact.jsp";
	}
	
	@RequestMapping(value= "/contacts/new", method=RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("students",apiService.findAllStudents());
			return "newContact.jsp";
		}
			apiService.createContact(contact);
			return "redirect:/students";
	}
	
	

}
