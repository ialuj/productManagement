package com.cayena.api.productManagement.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.model.entity.Supplier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SupplierQueryServiceTest {
	
	@Autowired
	private ISupplierQueryService supplierQueryService;
	
	@Test
	public void shouldFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS";

		final Supplier supplier = supplierQueryService.getSupplierByName(name);

		assertNotNull(supplier);

		assertEquals(name, supplier.getName());

	}

	@Test
	public void shouldNotFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS DE SP";

		final Supplier supplier = supplierQueryService.getSupplierByName(name);

		assertNull(supplier);

	}

}
