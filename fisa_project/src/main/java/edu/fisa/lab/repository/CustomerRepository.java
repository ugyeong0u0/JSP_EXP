package edu.fisa.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.model.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
