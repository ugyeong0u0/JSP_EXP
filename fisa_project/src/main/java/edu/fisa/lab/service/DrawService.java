package edu.fisa.lab.service;

import java.sql.SQLException;
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
import fisa.lab.exception.NotExistExceptions;
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
	public void createDraw(Long productId, Long customerId) throws SQLException,NotExistExceptions{
		Optional<Customer> c = customerRepository.findById(customerId);
		Optional<Product> p = productRepository.findById(productId);
		Optional<Draw> d = drawRepository.findByProduct_productId(productId);
		System.out.println(d.get().getDrawId());
		if(d.isEmpty()) {
			Draw newD = new Draw();	
			c.get().addDraw(newD);
			p.get().addDraw(newD);
			drawRepository.save(newD);
		} else {
			System.out.println("이미 추가하신 상품입니다.");
			throw new NotExistExceptions("이미 추가하신 상품입니다.");
		}
	}

	public List<DrawDto> findAll(Long customerId) {
		List<DrawDto> d = drawRepository.findAll(customerId);
		return drawRepository.findAll(customerId);
	}
	
	
}
