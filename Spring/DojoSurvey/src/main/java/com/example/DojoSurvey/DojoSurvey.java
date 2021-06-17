package com.example.DojoSurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurvey {
	
	@RequestMapping("/")
	public String survey() {
		return "survey.jsp";
	}
	
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String result(Model model,@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		if(language.equals("java")) {
			return "javapage.jsp";
		}
		return "result.jsp";
	}
	

}
