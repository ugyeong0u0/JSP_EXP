package edu.fisa.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.model.domain.Product;
	
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

//	@Query("select productId from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectProductIdById(@Param("customerid") Long customerid);
//	
//	@Query("select productName from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectProductNameById(@Param("customerid") Long customerid);
//	
//	@Query("select price from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectPriceById(@Param("customerid") Long customerid);
//	
//	@Query("select brand from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectBrandById(@Param("customerid") Long customerid);
//	
//	@Query("select size from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectSizeById2(@Param("customerid") Long customerid);
//	
//	@Query("select category from Product p inner join Customer c on p.customerId =:c.customerid "
//			+ "and where c.customerId=:customerid")
//	Long selectCategoryById2(@Param("customerid") Long customerid);
	

		
}
