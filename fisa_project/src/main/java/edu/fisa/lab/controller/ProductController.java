package edu.fisa.lab.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller	
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 * 조회 파트 
	 * */
	@RequestMapping(path = "/productOne", method = RequestMethod.GET)
	public ProductDto productOne(@RequestParam("productId") Long productId) {
		
		ProductDto one = productService.productOne(productId);
		return one;	
	}
	
	/* 요청시 select 후 요청 객체에 데이터 저장 후 allpage.jsp 웹페이지 이동 및 응답
	 * 요청 객체 , jsp 이름 인식
	 * 
	 */
	@RequestMapping(path = "/productAll", method = RequestMethod.GET)
	public ModelAndView productAll() {
		List<ProductDto> one = productService.productAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("productAll", one);
		mv.setViewName("allpage");
		return mv;
	}
	
	/*
	 * 상품 저장 파트 
	 * */
	@RequestMapping(path = "/productSave", method = RequestMethod.POST)
	public String productInsert(ProductDto productDto) {
		productService.productInsert(productDto);
		return "redirect:/pants.jsp";
	}

}
