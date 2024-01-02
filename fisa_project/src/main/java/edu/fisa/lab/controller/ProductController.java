package edu.fisa.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("productOne")
	public String productAll(@RequestParam("productId") Long productId) {
		ProductDto one = productService.productOne(productId);
		return one.getProductName();
		
	}
	
	
}
