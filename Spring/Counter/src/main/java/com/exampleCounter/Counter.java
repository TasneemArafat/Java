package com.exampleCounter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	
	@RequestMapping("")
	public String homepage(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if(count == null) {
        	session.setAttribute("count", 1);
        }
        
        else {
        	count++;
        	session.setAttribute("count", count);
        }
        return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
        session.getAttribute("count");
        return "counter.jsp";
	}
	
	@RequestMapping("/incByTwo")
	public String incByTwo(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if(count == null) {
        	session.setAttribute("count", 1);
        }
        
        else {
        	count+=2;
        	session.setAttribute("count", count);
        }
        return "incByTwo.jsp";
	}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.removeAttribute("count");
        return "redirect:/";
	}

}
