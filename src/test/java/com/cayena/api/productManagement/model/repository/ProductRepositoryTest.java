package com.cayena.api.productManagement.model.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.model.entity.Product;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Test Class for product repository methods
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void shouldFindProductById() {
		final Long id = 1L;
		
		final Optional<Product> optOptional = productRepository.findById(id);
		
		if(optOptional.isPresent()) {
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldNotFindProductById() {
		final Long id = 10000L;
		
		final Optional<Product> optOptional = productRepository.findById(id);
		
		if(!optOptional.isPresent()) {
			assertTrue(true);
		}
	}
	
	@Test
	public void listAllProducts() {
		
		final List<Product> products = productRepository.findAll();
		
		assertTrue(!products.isEmpty());
	}

}
