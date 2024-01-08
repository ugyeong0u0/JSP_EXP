package edu.fisa.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.model.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
