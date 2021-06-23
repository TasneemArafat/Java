package com.example.DriversLicense.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DriversLicense.Service.ApiService;
import com.example.DriversLicense.models.License;
import com.example.DriversLicense.models.Person;

@Controller
public class ApiController {
	
	private final ApiService apiService;

	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		apiService.createPerson(person);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("AllPersons",apiService.findAllNullLicenses());
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}
		apiService.createLicense(license);
		return "redirect:/allData";
	}
	
	@RequestMapping("/allData")
	public String allData(Model model) {
		model.addAttribute("allPersons",apiService.findAllPersons());
		return "allData.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", apiService.findById(id));
		return "person.jsp";
	}
	
	
	

}
