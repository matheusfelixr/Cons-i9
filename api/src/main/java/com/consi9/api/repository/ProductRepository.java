package com.consi9.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.consi9.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

	
	Product findById(Long idProduct);

	@Query("select p from Product p where p.name like %:name% and ( p.costValue = :costValue OR :costValue is null ) and ( p.saleValue = :saleValue OR :saleValue is null )")
	List<Product> findByParameters(@Param("name") String name, @Param("costValue") Float costValue, @Param("saleValue") Float saleValue);
}
