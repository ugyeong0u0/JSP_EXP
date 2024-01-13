package edu.fisa.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fisa.lab.customer.dto.DrawDto;
import edu.fisa.lab.model.domain.Customer;
import edu.fisa.lab.model.domain.Draw;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.repository.CustomerRepository;
import edu.fisa.lab.repository.DrawRepository;
import edu.fisa.lab.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class DrawService {

	@Autowired
	private DrawRepository drawRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void createDraw(Long productId, Long customerId) {
		Optional<Customer> c = customerRepository.findById(customerId);
		Optional<Product> p = productRepository.findById(productId);
		Draw d = new Draw();	
		c.get().addDraw(d);
		p.get().addDraw(d);
		drawRepository.save(d);
	}

	public List<DrawDto> findAll(Long customerId) {
		List<DrawDto> d = drawRepository.findAll(customerId);
		return drawRepository.findAll(customerId);
	}
	
	
}
