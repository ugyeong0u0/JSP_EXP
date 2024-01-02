package edu.fisa.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public ProductDto productOne(Long productId) {
		Optional<Product> one = productRepository.findById(productId);
		ProductDto dto = new ProductDto();
		dto.setProductName(one.get().getProductName());
		return dto;
	}
}
