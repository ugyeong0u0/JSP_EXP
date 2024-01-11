package edu.fisa.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.customer.dto.ProductDto;
import edu.fisa.lab.model.domain.Category;
import edu.fisa.lab.model.domain.Product;
	
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "select * from product p inner join customer c on p.customer_id = c.customer_id "
			+ "where c.customer_id = :customerId", nativeQuery = true)
	List<ProductDto> findAllByCustomerId(@Param("customerId") Long customerId);
	
//	@Query(value = "select p.productName from product p inner join customer c on p.customerId = c.customerId "
//			+ "where c.customerId = :customerId", nativeQuery = true)
//	String findByCustomerId2(@Param("customerId") Long customerId);
////	
//	@Query(value = "select p.price from Product p inner join Customer c on p.customerId = c.customerId "
//			+ "where c.customerId = :customerId", nativeQuery = true)
//	int findByCustomerId3(@Param("customerId") Long customerId);
//	
//	@Query(value = "select p.brand from Product p inner join Customer c on p.customerId = c.customerId "
//			+ "where c.customerId = :customerId", nativeQuery = true)
//	String findByCustomerId4(@Param("customerId") Long customerId);
//	
//	@Query(value = "select p.size from Product p inner join Customer c on p.customerId = c.customerId "
//			+ "where c.customerId = :customerId", nativeQuery = true)
//	int findByCustomerId5(@Param("customerId") Long customerId);
//	
//	@Query(value = "select p.category from Product p inner join Customer c on p.customerId = c.customerId "
//			+ "where c.customerId = :customerId", nativeQuery = true)
//	Category findByCustomerId6(@Param("customerId") Long customerId);
		
}
