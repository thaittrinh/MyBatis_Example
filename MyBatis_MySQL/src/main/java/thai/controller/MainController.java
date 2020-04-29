package thai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	 @RequestMapping("/")
	  public String redirect() {
		 return "redirect: login";
	 }
	
	 @RequestMapping("/login")
	  public String formLogin() {
		 return "login/login";
	 }
	 
	 @RequestMapping("/register")
	  public String register() {
	    return "login/register";
	  }
	 

}