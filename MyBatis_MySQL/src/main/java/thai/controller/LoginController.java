package thai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import thai.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	 @RequestMapping("/login")
	  public String formLogin() {
		 
		 return "login/login";
	 }
	 

	 @RequestMapping("/register")
	  public String register() {
	    return "login/register";
	  }
}
