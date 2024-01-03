package edu.fisa.lab.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		customerService.insertCustomer(customerDto);
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		out.print("id : " + id);
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		return "redirect:/pants.jsp";
	}
	
	@RequestMapping(path = "/Draws", method = RequestMethod.PUT)
	public String updateCustomer(Long productId, Long customerId) throws Exception {
		String check = customerService.updateCustomer(productId, customerId);
		return check;
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model m) {
		m.addAttribute("errorMsg", "발생된 이슈 " + e.getMessage());
		e.printStackTrace();
		return "forward:showError.jsp";
	}
}
