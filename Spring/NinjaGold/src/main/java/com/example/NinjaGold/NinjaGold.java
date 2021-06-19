package com.example.NinjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NinjaGold {

	@RequestMapping("/gold")
	public String home(Model model,HttpSession session) {
		if(session.getAttribute("score")==null) {
		session.setAttribute("score", 0);
		session.setAttribute("activities",new ArrayList<String>());
		}
		Integer score = (Integer) session.getAttribute("score");
//		ArrayList<String> act = (ArrayList<String>) session.getAttribute("activities");
		return "home.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(RedirectAttributes redirectAttributes,
			Model model, HttpSession session, @RequestParam(value="gold") String gold) {
		Random r = new Random();
		int newScore;
		ArrayList<String> act = (ArrayList<String>) session.getAttribute("activities");
		Integer score = (Integer) session.getAttribute("score");
		if(gold.equals("farm")) {
			newScore = r.nextInt(10)+10;
			score += newScore;
			act.add("You entered a farm and earned "+newScore+" gold. ("+new java.util.Date()+")");
			session.setAttribute("score", score);
		}
		if(gold.equals("cave")) {
			newScore = r.nextInt(5)+5;
			score += newScore;
			act.add("You entered a cave and earned "+newScore+" gold. ("+new java.util.Date()+")");
			session.setAttribute("score", score);
		}
		if(gold.equals("house")) {
			newScore = r.nextInt(3)+2;
			score += newScore;
			act.add("You entered a house and earned "+newScore+" gold. ("+new java.util.Date()+")");
			session.setAttribute("score", score);
		}
		if(gold.equals("casino")) {
			newScore = r.nextInt(100)-50;
			score += newScore;
			if(newScore < 0) {
			act.add("<span style='color:red;'>You entered a casino and lost "+newScore*-1+" gold.. Ouch. ("+new java.util.Date()+")</span>");
			session.setAttribute("score", score);
			}
			else {
			act.add("You entered a casino and earned "+newScore+" gold. ("+new java.util.Date()+")");
			session.setAttribute("score", score);
			}
		}
		return "redirect:/gold";
	}
}
