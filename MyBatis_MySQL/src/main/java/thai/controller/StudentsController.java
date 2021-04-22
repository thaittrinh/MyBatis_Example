package thai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import thai.dto.PageDTO;
import thai.dto.SortBy;
import thai.service.StudentDetailService;

@Controller
public class StudentsController {

	@Autowired
	StudentDetailService studentDetailService;

	@GetMapping("/students")
	public ModelAndView student(HttpSession session) {

		ModelAndView mav = new ModelAndView();

		// no avilable date // set total student/page default 10.
		PageDTO pageDTO = new PageDTO("", "", SortBy.STUDENT_CODE, 0, 10);

		session.setAttribute("StorePageDTO", pageDTO);

		mav.addObject("Students", studentDetailService.findAll(pageDTO));
		mav.addObject("totalPage", studentDetailService.totalPage(pageDTO));
	
		mav.addObject("PageDTO", pageDTO);
		mav.addObject("startPage", 1);

		mav.setViewName("student/students");

		return mav;
	}

	@GetMapping("/search")
	public ModelAndView search(HttpSession session, @ModelAttribute("PageDTO") PageDTO pageDTO) {

		ModelAndView mav = new ModelAndView();

		PageDTO sessionPage = (PageDTO) session.getAttribute("StorePageDTO");
		sessionPage.setName(pageDTO.getName());
		sessionPage.setCode(pageDTO.getCode());

		// refresh page
		sessionPage.setStartItem(0);
		sessionPage.setItems(10);

		mav.addObject("Students", studentDetailService.findAll(sessionPage));
		mav.addObject("totalPage", studentDetailService.totalPage(sessionPage));
		mav.addObject("startPage", 1);
		session.setAttribute("StorePageDTO", sessionPage);
		
		mav.setViewName("student/students");

		return mav;
	}

	@GetMapping("/page/{page}")
	public ModelAndView page(HttpSession session, @PathVariable int page) {

		ModelAndView mav = new ModelAndView();

		PageDTO sessionPage = (PageDTO) session.getAttribute("StorePageDTO");
		sessionPage.setStartItem((page - 1) * sessionPage.getItems()); // page 1 start = index0, page2 start= index10
		session.setAttribute("StorePageDTO", sessionPage);

		mav.addObject("Students", studentDetailService.findAll(sessionPage));
		mav.addObject("totalPage", studentDetailService.totalPage(sessionPage));
		mav.addObject("PageDTO", sessionPage);
		mav.addObject("startPage", page);

		mav.setViewName("student/students");

		return mav;
	}

	@GetMapping("/sort/{name}")
	public ModelAndView sort(HttpSession session, @PathVariable SortBy name) {

		ModelAndView mav = new ModelAndView();

		PageDTO sessionPage = (PageDTO) session.getAttribute("StorePageDTO");
	    sessionPage.setSort(name);
		// refresh page
		sessionPage.setStartItem(0);
		sessionPage.setItems(10);

		mav.addObject("Students", studentDetailService.findAll(sessionPage));
		mav.addObject("totalPage", studentDetailService.totalPage(sessionPage));
		mav.addObject("startPage", 1);
		session.setAttribute("StorePageDTO", sessionPage);
		mav.addObject("PageDTO", sessionPage);
		
		mav.setViewName("student/students");

		return mav;
	}

}