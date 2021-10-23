package com.cayena.api.productManagement.model.service;

import java.util.List;

import com.cayena.api.productManagement.model.entity.Supplier;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface that exposes supplier query services
 *
 */
public interface ISupplierQueryService {
	
	public Supplier getSupplierById(final Long id);
	
	public Supplier getSupplierByName(final String name);
	
	public List<Supplier> listAllSuppliers();

}
