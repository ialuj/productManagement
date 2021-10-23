package com.cayena.api.productManagement.model.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.api.ISupplierQueryServiceWs;
import com.cayena.api.productManagement.dto.SupplierDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SupplierQueryServiceWsTest {

	@Autowired
	private ISupplierQueryServiceWs supplierQueryServiceWs;

	@Test
	public void shouldFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS";

		final ResponseEntity<SupplierDTO> supplier = supplierQueryServiceWs.getSupplierByName(name);

		assertNotNull(supplier);

		assertEquals(ResponseEntity.ok().build().getStatusCode(), supplier.getStatusCode());

	}

	@Test
	public void shouldNotFindSupplierByName() {

		final String name = "AGRO PRODUÇÕES E INVESTIMENTOS DE SP";

		final ResponseEntity<SupplierDTO> supplier = supplierQueryServiceWs.getSupplierByName(name);

		assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build().getStatusCodeValue(), supplier.getStatusCodeValue());

	}

}
