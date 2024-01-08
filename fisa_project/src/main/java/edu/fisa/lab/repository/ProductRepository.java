package edu.fisa.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.model.domain.Product;
	
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select productId from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectProductIdById(@Param("customerid") Long customerid);
	
	@Query("select productName from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectProductNameById(@Param("customerid") Long customerid);
	
	@Query("select price from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectPriceById(@Param("customerid") Long customerid);
	@Query("select brand from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectBrandById(@Param("customerid") Long customerid);
	@Query("select size from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectSizeById2(@Param("customerid") Long customerid);
	@Query("select category from Product p inner join Customer c on p.customerId =c.customerid "
			+ "and where c.customerId=:customerid")
	int selectCategoryById2(@Param("customerid") Long customerid);
		
}
