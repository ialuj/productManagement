package com.cayena.api.productManagement.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cayena.api.productManagement.model.entity.Supplier;

/**
 * 
 * @author Jose Julai Ritsure
 *
 * Class that persists, updates, deletes and make queries Suppliers to the DB
 *
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
	@Query("select s from Supplier s where s.name = ?1")
	public Supplier getSupplierByName(final String name);

}
