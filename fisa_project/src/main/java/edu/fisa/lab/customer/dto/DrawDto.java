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
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DrawDto {
	
	private String name;
	private String productName;
	private int price;
	private String brand;
	private int size;
	private Category category;
	
	public DrawDto toDto(Product product, Customer customer) {
		return DrawDto.builder()
				.name (customer.getName())
				.productName(product.getProductName())
				.price(product.getPrice())
				.brand(product.getBrand())
				.size(product.getSize())
				.category(product.getCategory())
				.build();
	}
}
