package edu.fisa.lab.customer.dto;

import edu.fisa.lab.model.domain.Category;
import edu.fisa.lab.model.domain.Customer;
import edu.fisa.lab.model.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DrawDto {

	//고객이름 
	private String name;
	private String productName;
	private int price;
	private String brand;
	private int size;
	private Category category;
	

	public DrawDto(String name, String productName, int price, String brand, int size) {
		super();
		this.name = name;
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.size = size;
	}

}
