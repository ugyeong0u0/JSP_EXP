package edu.fisa.lab.customer.dto;

import edu.fisa.lab.model.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CustomerDto {
	private String name;
	private String password;
	
	public Customer toEntity(CustomerDto customerDto) {
		return Customer.builder().name(customerDto.getName()).password(customerDto.getPassword()).build();
	}

}
