package edu.fisa.lab.customer.dto;

import edu.fisa.lab.model.domain.Category;
import edu.fisa.lab.model.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

	private String productName;
	private int price;
	private boolean drawCheck;
	private String brand;
	private int size;
	private boolean gender;
	private Category category;
	

}
