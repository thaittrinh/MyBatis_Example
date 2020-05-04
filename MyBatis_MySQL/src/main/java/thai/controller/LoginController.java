package thai.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import thai.entity.User;
import thai.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public ModelAndView formLogin() {

		ModelAndView mav = new ModelAndView("login/login");
		mav.addObject("User", new User());
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView checkLogin(HttpSession session, @Valid @ModelAttribute("User") User user,
			BindingResult result) {

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			
			mav.setViewName("login/login");
		} else {

			boolean bl = userService.checkLogin(user);
			if (bl) {

				// session.setMaxInactiveInterval(60*60);
				session.setAttribute("Session_User", userService.getOneByName(user.getName()));
				mav.setViewName("student/students");
			} else {

				mav.setViewName("login/login");
				mav.addObject("message", "Wrong name or password!!!");
			}
		}

		return mav;
	}

	@GetMapping("/register")
	public ModelAndView formRegister(ModelMap model) {

		ModelAndView mv = new ModelAndView("login/register");
		mv.addObject("User", new User());

		return mv;
	}

	@PostMapping("/register")
	public ModelAndView register(HttpSession session ,
			@RequestParam(name = "confirmPassword", defaultValue = "") String passwordConfirm,
			@Valid @ModelAttribute("User") User user,
			 BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
		
			mav.setViewName("login/register");
		} else {
			if (!user.getPassword().equals(passwordConfirm)) {

				mav.addObject("message", "The confirmation password is wrong");
				mav.setViewName("login/register");
			} else {
				if (userService.register(user)) {

					session.setAttribute("Session_User", userService.getOneByName(user.getName()));
					mav.setViewName("student/students");
				} else {

					mav.addObject("message", "Registration failed!!!");
					mav.setViewName("login/register");
				}
			}
		}
		
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logOut(HttpSession session) {

		session.removeAttribute("Session_User");

		return new ModelAndView("redirect:login");

	}
}
