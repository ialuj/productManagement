package com.cayena.api.productManagement.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductQueryServiceTest {

	@Autowired
	private IProductQueryService productQueryService;

	@Test
	public void shouldFindProductById() {
		final Long id = 1L;

		final Product product = productQueryService.getProductById(id);

		assertNotNull(product);
	}

	@Test
	public void shouldNotFindProductById() {
		final Long id = 10000L;

		try {
			productQueryService.getProductById(id);
		} catch (BusinessException | NoSuchElementException e) {
			assertEquals("Product with ID: " + id + " does not exist!", e.getMessage());
		}
	}

	@Test
	public void listAllProducts() {

		final List<Product> products = productQueryService.listAllProducts();

		assertTrue(!products.isEmpty());
	}

}
