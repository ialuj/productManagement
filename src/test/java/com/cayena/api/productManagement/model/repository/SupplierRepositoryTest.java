package com.cayena.api.productManagement.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.model.entity.Supplier;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Test Class for supplier repository methods
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SupplierRepositoryTest {

	@Autowired
	private SupplierRepository supplierRepository;

	@Test
	public void shouldFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS";

		final Supplier supplier = supplierRepository.getSupplierByName(name);

		assertNotNull(supplier);

		assertEquals(name, supplier.getName());

	}

	@Test
	public void shouldNotFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS DE SP";

		final Supplier supplier = supplierRepository.getSupplierByName(name);

		assertNull(supplier);

	}

	@Test
	public void listAllSuppliers() {

		final List<Supplier> suppliers = supplierRepository.findAll();

		assertTrue(!suppliers.isEmpty());

	}

}
