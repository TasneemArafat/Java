package com.example.Languages.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Languages.models.Language;
import com.example.Languages.services.LanguageService;

@Controller
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model,@ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages",languages);
		return "homepage.jsp";
	}
	
	@RequestMapping(value = "/languages/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "homepage.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language =  languageService.findLanguage(id);
		model.addAttribute(language);
		return "show.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute(language);
		System.out.println("edit");
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}",method = RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("language") Language language, BindingResult result ) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			
			languageService.updateLanguage(language.getId(),language.getName(),language.getCreator(),language.getVersion());
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}",method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
