package com.cayena.api.productManagement.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.cayena.api.productManagement.dto.SupplierDTO;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes endpoints for getting a supplier by id / name, and
 *         listing all suppliers
 *
 */
public interface ISupplierQueryServiceWs {
	
	public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable("id") Long id);
	
	public ResponseEntity<SupplierDTO> getSupplierByName(@PathVariable("name") String name);

	public ResponseEntity<List<SupplierDTO>> listAllSuppliers();

}
