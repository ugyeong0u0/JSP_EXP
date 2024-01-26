package edu.fisa.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Category;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.repository.CustomerRepository;
import edu.fisa.lab.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public ProductDto productOne(Long productId) {
		Optional<Product> one = productRepository.findById(productId); // 값이 존재 할수도 없을 수도 있음 
		ProductDto dto = new ProductDto().toDto(one.get()); // productDto로 변경 
		return dto;
	}
	
	@Transactional
	public List<ProductDto> productAll() {
		List<Product> pro = productRepository.findAll();
		List<ProductDto> pList = pro.stream().map(p -> new ProductDto().toDto(p)).toList();
		return pList;
	}
	// 상품 저장 
	@Transactional
	public String productInsert(ProductDto productDto) {
		
		if(productDto.getClassify().equals("바지")) {
			productDto.setCategory(Category.pants);
		} else if(productDto.getClassify().equals("상의")) {
			productDto.setCategory(Category.top);
		} else {
			productDto.setCategory(Category.shoese);
		}
		System.out.println(productDto.getClassify());
		Product p = new ProductDto().toEntity(productDto);
		Product product = productRepository.save(p);
		return product.getProductName();
	}
	
//	@Transactional
//	public List<ProductDto> findAllByCustomerId(Long customerId) {
//		List<ProductDto> pd2 = productRepository.findAllByCustomerId(customerId);
//		return pd2;
//	}
	
//	@Transactional
//	public List<Product> findAllByCustomer(Long customerId) {
//		List<Product> pd2 = productRepository.findAllByCustomer(customerId);
//		return pd2;
//	}
	
}
