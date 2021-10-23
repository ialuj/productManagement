package com.cayena.api.productManagement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayena.api.productManagement.model.entity.Supplier;
import com.cayena.api.productManagement.model.repository.SupplierRepository;

/**
 * 
 * @author Jose Julai Ritsure
 *
 * Supplier Services Implementation
 *
 */
@Service
public class SupplierQueryServiceImpl implements ISupplierQueryService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier getSupplierById(Long id) {
		return supplierRepository.getById(id);
	}

	@Override
	public Supplier getSupplierByName(String name) {
		return supplierRepository.getSupplierByName(name);
	}

	@Override
	public List<Supplier> listAllSuppliers() {
		return supplierRepository.findAll();
	}

}
