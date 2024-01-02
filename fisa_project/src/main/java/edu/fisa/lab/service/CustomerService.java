package edu.fisa.lab.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fisa.lab.customer.dto.CustomerDto;
import edu.fisa.lab.model.domain.Customer;
import edu.fisa.lab.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Transactional
	public void insertCustomer(CustomerDto customerDto) {
		
		Customer c = customerDto.toEntity(customerDto);
		
		System.out.println(c.getId());
		System.out.println(c.getPassword());
		customerRepository.save(c);
	}
}
