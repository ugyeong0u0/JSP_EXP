package edu.fisa.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import edu.fisa.lab.model.domain.Product;
	
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "select p.productId from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId(@Param("customerId") Long customerId);
	
	@Query(value = "select p.productName from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId2(@Param("customerId") Long customerId);
	
	@Query(value = "select p.price from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId3(@Param("customerId") Long customerId);
	
	@Query(value = "select p.brand from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId4(@Param("customerId") Long customerId);
	
	@Query(value = "select p.size from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId5(@Param("customerId") Long customerId);
	
	@Query(value = "select p.category from Product p inner join Customer c on p.customerId = c.customerId "
			+ "where c.customerId = :customerId", nativeQuery = true)
	Long findByCustomerId6(@Param("customerId") Long customerId);
		
}
