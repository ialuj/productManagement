package com.cayena.api.productManagement.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cayena.api.productManagement.model.entity.Product;

/**
 * 
 * @author Jose Julai Ritsure
 *
 * Class that persists, updates, deletes and make queries Products to the DB
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("select p from Product p order by p.creationDate desc")
	public List<Product> listAllProducts();

}
