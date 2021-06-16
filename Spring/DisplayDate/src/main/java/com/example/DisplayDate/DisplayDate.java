package com.example.DisplayDate;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDate {

	@RequestMapping("")
	public String homepage() {
		return "index.jsp";
	}
	
	@RequestMapping("date")
	public String datepage(Model model) {
		java.util.Date Date = new java.util.Date();
		SimpleDateFormat day = new SimpleDateFormat("EEEE, dd MMM yyyy");  
	    String stDate = day.format(Date);  
	        model.addAttribute("Date", stDate);
		return "date.jsp";
	}
	
	@RequestMapping("time")
	public String timepage(Model model) {
		java.util.Date Time = new java.util.Date();
		SimpleDateFormat time = new SimpleDateFormat("h:mm a");  
	    String stTime = time.format(Time);  
	        model.addAttribute("Time", stTime);
		return "time.jsp";
	}
	
}
