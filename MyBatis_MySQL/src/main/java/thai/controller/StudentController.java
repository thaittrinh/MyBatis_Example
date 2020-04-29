package thai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	 @RequestMapping("/students")
	  public String students() {
		 
		 return "student/students";
	 }
	
	 @RequestMapping("/student")
	  public String student() {
		 
		 return "student/student";
	 }
	
	
}
