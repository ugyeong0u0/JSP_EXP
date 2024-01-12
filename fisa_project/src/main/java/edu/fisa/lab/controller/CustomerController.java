package edu.fisa.lab.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fisa.lab.customer.dto.CustomerDto;
import edu.fisa.lab.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public String insertCustomer(CustomerDto customerDto, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Long customerId = customerService.insertCustomer(customerDto);
		String name = request.getParameter("name");

		HttpSession session = request.getSession();
		session.setAttribute("customerId", customerId);
		session.setAttribute("name", name);
		return "redirect:/pants.jsp";
	}
	
	//고객이 응모한 상품추가
	@RequestMapping(path = "/Draws", method = RequestMethod.GET)
	public String updateCustomer(Long productId, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Long customerId = (Long) session.getAttribute("customerId");		
		customerService.insertCustomer(customerId, productId);
		return "redirect:/pants.jsp";
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model m) {
		m.addAttribute("errorMsg", "발생된 이슈 " + e.getMessage());
		e.printStackTrace();	
		return "forward:showError.jsp";
	}
}
