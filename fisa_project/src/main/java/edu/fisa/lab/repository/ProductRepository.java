package edu.fisa.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Category;
import edu.fisa.lab.model.domain.Product;
	

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

//	@Query(value = "select "
//			+ "new edu.fisa.lab.customer.dto.ProductDto(p.productName, p.price, p.brand, p.size, p.category)"
//			+ "from Product p join customer c "
//			+ "where c.customerId = :customerId")
//	List<ProductDto> findAllByCustomerId(@Param("customerId") Long customerId);

	//List<Product> findAllByCustomer(@Param("customerId") Long customerId);
}
