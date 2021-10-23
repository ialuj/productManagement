package com.cayena.api.productManagement.model.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.api.IProductQueryServiceWs;
import com.cayena.api.productManagement.dto.ProductDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductQueryServiceWsTest {

	@Autowired
	private IProductQueryServiceWs productQueryServiceWs;

	@Test
	public void shouldFindProductById() {
		final Long id = 1L;

		final ResponseEntity<ProductDTO> productResponseEntity = productQueryServiceWs.getProductById(id);
		
		final ProductDTO product = productResponseEntity.getBody();

		assertNotNull(product);
		
		assertEquals(id, product.getId());
	}

	@Test
	public void listAllProducts() {

		final ResponseEntity<List<ProductDTO>> responseEntity = productQueryServiceWs.listAllProducts();
		
		final List<ProductDTO> products = responseEntity.getBody();

		assertTrue(!products.isEmpty());
	}

}
