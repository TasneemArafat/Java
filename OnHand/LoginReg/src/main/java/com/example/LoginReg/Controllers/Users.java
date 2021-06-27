package com.example.LoginReg.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LoginReg.Services.UserService;
import com.example.LoginReg.models.User;
import com.example.LoginReg.validation.UserValidator;

@Controller
public class Users {

    private final UserService userService;
    private final UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login(HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "loginPage.jsp";
    	}
        return "redirect:/home";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        
    	// if result has errors, return the registration page (don't worry about validations just now)
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	else {
    		if(userService.findByEmail(user.getEmail()) != null) {
    			model.addAttribute("error","Email already exists!");
    			return "registrationPage.jsp";
    		}
    		userService.registerUser(user);
    		session.setAttribute("userId", user.getId());
    		return "redirect:/home";
    	}
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	// if the user is authenticated, save their user id in session
    	if(userService.authenticateUser(email, password)) {
    		Long id = userService.findByEmail(email).getId();
    		session.setAttribute("userId", id);
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	else {
    		model.addAttribute("error","Invalid Username or Password");
    		return "loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	// get user from session, save them in the model and return the home page
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/registration";
    	}
    	Long id = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(id);
    	model.addAttribute("user",user);
    	return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	// invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
