package com.example.LoginReg.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LoginReg.Services.UserService;
import com.example.LoginReg.Services.appService;
import com.example.LoginReg.models.Event;
import com.example.LoginReg.models.Message;
import com.example.LoginReg.models.State;
import com.example.LoginReg.models.User;
import com.example.LoginReg.validation.UserValidator;

@Controller
public class Users {

    private final UserService userService;
    private final UserValidator userValidator;
    private final appService appServ;
    
    public Users(UserService userService, UserValidator userValidator, appService appServ) {
		super();
		this.userService = userService;
		this.userValidator = userValidator;
		this.appServ = appServ;
	}

// Login and Registration Page main Route
    
	@RequestMapping("/")
    public String loginRegPage(@ModelAttribute("user") User user,HttpSession session,Model model){
		model.addAttribute("states",appServ.getAllStates());
    	if(session.getAttribute("userId") != null) {
    		return "redirect:/events";
    	}
        return "registrationPage.jsp";
    }
    

// Registration process
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	model.addAttribute("states",appServ.getAllStates());
    	// if result has errors, return the registration page (don't worry about validations just now)
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /events route
    	else {
    		if(userService.findByEmail(user.getEmail()) != null) {
    			model.addAttribute("error","Email already exists!");
    			return "registrationPage.jsp";
    		}
    		userService.registerUser(user);
    		session.setAttribute("userId", user.getId());
    		return "redirect:/events";
    	}
    	
    }

 // Login process
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,
    		@ModelAttribute("user") User user) {
    	// if the user is authenticated, save their user id in session
    	if(userService.authenticateUser(email, password)) {
    		Long id = userService.findByEmail(email).getId();
    		session.setAttribute("userId", id);
    		return "redirect:/events";
    	}
        // else, add error messages and return the login page
    	else {
    		model.addAttribute("error","Invalid Username or Password");
    		return "registrationPage.jsp";
    	}
    }
    
// events Route
    @RequestMapping("/events")
    public String events(@ModelAttribute("event") Event event,HttpSession session, Model model) {
    	// get user from session, save them in the model and return the events page
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("Events",user.getState().getEvents());
    	model.addAttribute("states",appServ.getAllStates());
    	model.addAttribute("user",user);
    	model.addAttribute("outStatesEvents",appServ.eventsNotInState(user.getState()));
    	return "eventsPage.jsp";
    }
// Create Event
    @RequestMapping(value="/events", method=RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,HttpSession session, Model model) {
    	if(result.hasErrors()) {
        	Long id = (Long) session.getAttribute("userId");
        	User user = userService.findUserById(id);
        	model.addAttribute("outStatesEvents",appServ.eventsNotInState(user.getState()));
    		model.addAttribute("states",appServ.getAllStates());
    		return "eventsPage.jsp";
    	}
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	appServ.createEvent(event);
    	System.out.println(event.getName());
    	System.out.println(user.getFirst_name());
    	appServ.joinEvent(event, user);
    	return "redirect:/events";
    }
    
    @RequestMapping("/joinEvent/{id}")
    public String joinEvent(@PathVariable("id") Long eventId,HttpSession session) {
    	Event event = appServ.getEventById(eventId);
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	appServ.joinEvent(event, user);
    	return "redirect:/events";
    }
    
    @RequestMapping("/cancelEvent/{id}")
    public String cancelEvent(@PathVariable("id") Long eventId,HttpSession session) {
    	Event event = appServ.getEventById(eventId);
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	appServ.cancelEvent(event, user);
    	return "redirect:/events";
    }
    
// LogOut
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	// invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/";
    }
    
// create State
    @RequestMapping("/state")
    public String statePage(@ModelAttribute("state") State state) {
    	return "addState.jsp";
    }
    
    @RequestMapping(value="/state", method=RequestMethod.POST)
    public String createState(@ModelAttribute("state") State state) {
    	appServ.createState(state);
    	return "redirect:/state";
    }
    
// Show Event
    @RequestMapping("/events/{id}")
    public String showEvent(@PathVariable("id") Long eventId,HttpSession session, Model model,@ModelAttribute("mess") Message mess) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("Event",appServ.getEventById(eventId));
    	model.addAttribute("num",appServ.getEventById(eventId).getUsers().size());
    	model.addAttribute("user",user);
    	return "showEvent.jsp";
    }
    
    @RequestMapping(value="/message",method=RequestMethod.POST)
    public String addMessage(HttpSession session, Model model,@ModelAttribute("mess") Message mess) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user",user);
    	appServ.createMessage(mess);
    	return "redirect:/events/"+ mess.getEvent().getId();
    }
    
    @RequestMapping("/events/{id}/edit")
    public String editPage(@Valid @ModelAttribute("event") Event event,@PathVariable("id") Long eventId,Model model,
    		HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}	
    	model.addAttribute("states",appServ.getAllStates());
    	model.addAttribute("event",appServ.getEventById(eventId));
    	return "editPage.jsp";
    	
    }
    
    @RequestMapping(value="/events/{id}/edit",method=RequestMethod.PUT)
    public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,Model model) {
    	if(result.hasErrors()) {
    		model.addAttribute("states",appServ.getAllStates());
    		return "editPage.jsp";
    	}
    	appServ.updateEvent(event);
    	return "redirect:/events";
    }
    
    @RequestMapping(value="/events/{id}",method=RequestMethod.DELETE)
    public String deleteEvent(@PathVariable("id") Long eventId) {
    	appServ.deleteEvent(eventId);
    	return "redirect:/events";
    }

}
