package edu.fisa.lab.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.fisa.lab.customer.dto.DrawDto;
import edu.fisa.lab.service.DrawService;
import fisa.lab.exception.NotExistExceptions;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DrawController {

	@Autowired
	private DrawService drawService;
	
	//응모 생성
	@RequestMapping(path = "/drawCreate", method = RequestMethod.GET)
	public String createDraw(@RequestParam("productId") Long productId, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Long customerId = (Long) session.getAttribute("customerId");
		drawService.createDraw(productId, customerId);
		return "redirect:/pants.jsp";
	}
	
	//고객 응모 조회
	@RequestMapping(path = "/drawAll", method = RequestMethod.GET)
	public ModelAndView findAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long customerId = (Long) session.getAttribute("customerId");
		List<DrawDto> d = drawService.findAll(customerId);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("drawAll", d);
		mv.setViewName("customerpage");
		return mv;
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model m) {
		m.addAttribute("errorMsg", "발생된 이슈 " + e.getMessage());
		e.printStackTrace();
		return "forward:showError.jsp";
	}
}
