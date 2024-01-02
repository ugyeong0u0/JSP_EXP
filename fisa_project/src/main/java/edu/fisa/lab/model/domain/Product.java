package edu.fisa.lab.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column//데이터베이스와 매핑
	private String productName;

	@Column
	private int price;

	@Column
	private boolean drawCheck;

	@Column
	private String brand;

	@Column
	private int size;

	@Column
	private boolean gender;

	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id") // Team4의 pk 변수에 선언된 매핑된 컬럼명
	private Customer customer;
	
	
}
