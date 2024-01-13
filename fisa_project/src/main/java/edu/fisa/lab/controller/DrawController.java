package edu.fisa.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.lab.customer.dto.DrawDto;
import edu.fisa.lab.service.DrawService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class DrawController {

	@Autowired
	private DrawService drawService;
	
	//응모 생성
	@GetMapping("/drawCreate")
	public String createDraw(@RequestParam("productId") Long productId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long customerId = (Long) session.getAttribute("customerId");
		System.out.println(customerId);
		drawService.createDraw(productId, customerId);
		return "redirect:/pants.jsp";
	}
	//고객 응모 조회
	@GetMapping("/drawAll")
	public List<DrawDto> findAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long customerId = (Long) session.getAttribute("customerId");
		return drawService.findAll(customerId);
	}
}
