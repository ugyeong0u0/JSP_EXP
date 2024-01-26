package edu.fisa.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.service.ProductService;

@Controller	
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 * 물건 단건 조회 파트 
	 * */
	@RequestMapping(path = "/productOne", method = RequestMethod.GET)
	public ProductDto productOne(@RequestParam("productId") Long productId) {
		
		ProductDto one = productService.productOne(productId);
		return one; 
	}
	
	/* 물건 전체 조회
	 *  요청시 select 후 요청 객체에 데이터 저장 후 allpage.jsp 웹페이지 이동 및 응답
	 * 요청 객체 , jsp 이름 인식
	 * 
	 */
	// 
	@RequestMapping(path = "/productAll", method = RequestMethod.GET)
	public ModelAndView productAll() {
		List<ProductDto> one = productService.productAll();
		ModelAndView mv = new ModelAndView(); // 뷰와 데이터를 담는 
		mv.addObject("productAll", one); // productAll 이름으로 데이터 리스트 담음
		mv.setViewName("allpage"); // 뷰 allpage(전체 상품 조회 페이지) 사용의미  
		return mv;
	}
	
	/*
	 * 상품 저장 파트 
	 * */
	@RequestMapping(path = "/productSave", method = RequestMethod.POST)
	public String productInsert(ProductDto productDto) {
		productService.productInsert(productDto);
		return "redirect:/pants.jsp"; // 상품 저장 후 메인 페이지인 pants.jsp로 이동 
	}

}
