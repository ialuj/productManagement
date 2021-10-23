package com.cayena.api.productManagement.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.entity.Supplier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ISupplierQueryService supplierQueryService;

	@Autowired
	private IProductQueryService productQueryService;

	@Autowired
	private IProductService productService;

	@Test
	public void shouldSaveProduct() {

		final Supplier supplier = supplierQueryService.getSupplierByName("AGRO PRODUÇÕES E INVESTIMENTOS");

		final String name = "Cebola";
		final double quantity = 200;
		final double unitPrice = 10;

		final Product product = new Product(name, quantity, unitPrice, supplier, Calendar.getInstance().getTime());

		final Product savedProduct = productService.saveProduct(product);

		assertNotNull(savedProduct.getCreationDate());
		assertNotNull(savedProduct.getId());

	}

	@Test
	public void shouldUpdateProduct() {

		final Long id = 1L;

		final Product product = productQueryService.getProductById(id);

		final double newQuantinty = 500;

		final double newUnitPrice = 15;

		product.setQuantityInStock(newQuantinty);
		product.setUnitPrice(newUnitPrice);

		final Product updatedProduct = productService.updateProduct(product);

		assertEquals(newQuantinty, updatedProduct.getQuantityInStock());
		assertEquals(newUnitPrice, updatedProduct.getUnitPrice());

	}

	@Test
	public void shouldDeleteProduct() {

		final Long id = 2L;

		final Product product = productQueryService.getProductById(id);

		productService.deleteProduct(id);

		try {
			productService.updateProduct(product);
		} catch (BusinessException e) {
			assertEquals("Product with ID: 2 does not exist!", e.getMessage());
		}
	}

	@Test
	public void shouldUpdateProductStock() {

		final Long id = 1L;

		final Product product = productQueryService.getProductById(id);

		final double newQuantinty = 50;

		final double expectedQuantity = newQuantinty + product.getQuantityInStock();

		final Product updatedProduct = productService.updateProductStock(id, newQuantinty, true);

		assertEquals(expectedQuantity, updatedProduct.getQuantityInStock());

	}

	@Test
	public void shouldNotUpdateProductStock() {

		final Long id = 1L;

		final Product product = productQueryService.getProductById(id);

		final double newQuantinty = 101;

		try {
			productService.updateProductStock(id, newQuantinty, false);
		} catch (BusinessException e) {
			assertEquals("The available quantity: " + product.getQuantityInStock() + " in Product with ID: " + id
					+ " and name: " + product.getName() + " is less than the quantity you intend to reduce: "
					+ newQuantinty, e.getMessage());
		}

	}

}
