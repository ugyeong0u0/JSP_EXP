package edu.fisa.lab.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.fisa.lab.customer.dto.CustomerDto;
import edu.fisa.lab.customer.dto.DrawDto;
import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Customer;
import edu.fisa.lab.model.domain.Product;
import edu.fisa.lab.repository.CustomerRepository;
import edu.fisa.lab.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	private ModelMapper mapper = new ModelMapper();
	
	@Transactional
	public Long insertCustomer(CustomerDto customerDto) {
		
		Customer c = customerDto.toEntity(customerDto);
		customerRepository.save(c);
		return c.getCustomerId();
	}

	

	public void updateCustomer(Long customerId, Long productId) throws Exception {
		Optional<Customer> c = customerRepository.findById(customerId);
		Optional<Product> p = productRepository.findById(productId);
		p.get().addProduct(c.get());
		customerRepository.save(c.get());
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model m) {
		m.addAttribute("errorMsg", "발생된 이슈 " + e.getMessage());
		e.printStackTrace();
		return "forward:showError.jsp";
	}

	@Transactional
	public List<DrawDto> customerDraw(Long customerId) {
		Optional<Customer> c = customerRepository.findById(customerId);
		
		return null;
	}
}
