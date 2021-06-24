package com.example.DojosAndNinjas.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DojosAndNinjas.Service.ApiService;
import com.example.DojosAndNinjas.models.Dojos;
import com.example.DojosAndNinjas.models.Ninja;

@Controller
public class ApiController {

	private final ApiService apiService;
	
	
	
	public ApiController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojos dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new",method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojos dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		apiService.createDojo(dojo);
		return "redirect:/ninjas/new";
		
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		model.addAttribute("allDojos",apiService.findAllDojos());
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new",method=RequestMethod.POST)
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		apiService.createNinja(ninja);
		return "redirect:/dojos/new";
		
	}
	
	@RequestMapping("/dojos/{id}")
	public String allNinjasToDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo",apiService.findDojoById(id));
		return "dojoNinjas.jsp";
	}
	
	
	
}
