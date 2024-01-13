package edu.fisa.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fisa.lab.customer.dto.DrawDto;
import edu.fisa.lab.model.domain.Draw;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {

	@Query(value = "select "
	+ "new edu.fisa.lab.customer.dto.DrawDto(c.name, p.productName, p.price, p.brand, p.size, p.category)"
	+ "from Draw d "
	+ "join customer c "
	+ "join product p "
	+ "where c.customerId = :customerId")
	List<DrawDto> findAll(@Param("customerId") Long customerId);
}
