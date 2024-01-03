package edu.fisa.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.service.ProductService;

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
	
	@RequestMapping(path = "/productAll", method = RequestMethod.GET)
	public List<ProductDto> productAll() {
		List<ProductDto> one = productService.productAll();
		return one;
	}
	
	/*
	 * 상품 저장 파트 
	 * */
	@RequestMapping(path = "/productSave", method = RequestMethod.POST)
	public String productInsert(ProductDto productDto) {
		System.out.println(productDto.getBrand());
		productService.productInsert(productDto);
		return "redirect:/pants.jsp";
	}
}
