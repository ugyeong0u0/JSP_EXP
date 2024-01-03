package edu.fisa.lab.customer.dto;

import edu.fisa.lab.model.domain.Category;
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
public class ProductDto {

	private String productName;
	private int price;
	private boolean drawCheck;
	private String brand;
	private int size;
	private boolean gender;
	private Category category;

	
	public Product toEntity(ProductDto productDto) {
		return Product.builder()
				.productName(productDto.getProductName())
				.price(productDto.getPrice())
				.drawCheck(productDto.isDrawCheck())
				.brand(productDto.getBrand())
				.size(productDto.getSize())
				.gender(productDto.isGender())
				.category(productDto.getCategory())
				.build();	
	}
	
	public ProductDto toDto(Product product) {
		return ProductDto.builder()
				.productName(product.getProductName())
				.price(product.getPrice())
				.drawCheck(product.isDrawCheck())
				.brand(product.getBrand())
				.size(product.getSize())
				.gender(product.isGender())
				.category(product.getCategory())
				.build();
	}
}
