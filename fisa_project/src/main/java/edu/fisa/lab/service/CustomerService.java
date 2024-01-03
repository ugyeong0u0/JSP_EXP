package edu.fisa.lab.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.fisa.lab.customer.dto.CustomerDto;
import edu.fisa.lab.model.domain.Customer;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.repository.CustomerRepository;
import edu.fisa.lab.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	private ModelMapper mapper = new ModelMapper();
	
	@Transactional
	public void insertCustomer(CustomerDto customerDto) {
		
		Customer c = customerDto.toEntity(customerDto);
		customerRepository.save(c);
	}

	@Transactional
	public String updateCustomer(Long productId, Long customerId) throws Exception {
		Optional<Customer> c = customerRepository.findById(customerId);
		Optional<Product> p = productRepository.findById(productId);
		
		if(c.isEmpty()) {
			throw new Exception("존재하지 않은 고객입니다.");
		}
		
		else if(p.isEmpty()) {
			throw new Exception("존재하지 않은 상품입니다.");
		}
		
		else {
			 p.get().addProduct(c.get());
		}
		return p.get().getProductName();
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model m) {
		m.addAttribute("errorMsg", "발생된 이슈 " + e.getMessage());
		e.printStackTrace();
		return "forward:showError.jsp";
	}
}
