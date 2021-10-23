package com.cayena.api.productManagement.model.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cayena.api.productManagement.api.IProductQueryServiceWs;
import com.cayena.api.productManagement.api.IProductServiceWs;
import com.cayena.api.productManagement.api.ISupplierQueryServiceWs;
import com.cayena.api.productManagement.dto.ProductDTO;
import com.cayena.api.productManagement.dto.SupplierDTO;
import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceWsTest {

	@Autowired
	private ISupplierQueryServiceWs supplierQueryServiceWs;

	@Autowired
	private IProductQueryServiceWs productQueryServiceWs;

	@Autowired
	private IProductServiceWs productServiceWs;

	@Test
	public void shouldSaveProduct() {

		final ResponseEntity<SupplierDTO> supplier = supplierQueryServiceWs
				.getSupplierByName("AGRO PRODUÇÕES E INVESTIMENTOS");

		final String name = "Cebola";
		final double quantity = 200;
		final double unitPrice = 10;

		final Product product = new Product(name, quantity, unitPrice, supplier.getBody().toSupllier(),
				Calendar.getInstance().getTime());

		final ProductDTO productDTO = new ProductDTO(product);

		final ResponseEntity<ProductDTO> savedProduct = productServiceWs.saveProduct(productDTO);

		assertNotNull(savedProduct.getBody().getId());
		assertEquals(name, savedProduct.getBody().getName());
		assertEquals(quantity, savedProduct.getBody().getQuantityInStock());
		assertEquals(unitPrice, savedProduct.getBody().getUnitPrice());
	}

	@Test
	public void shouldUpdateProduct() {

		final Long id = 1L;

		final ResponseEntity<ProductDTO> productResponseEntity = productQueryServiceWs.getProductById(id);

		final double newQuantinty = 500;

		final double newUnitPrice = 15;

		final ProductDTO productDTO = productResponseEntity.getBody();

		productDTO.setQuantityInStock(newQuantinty);
		productDTO.setUnitPrice(newUnitPrice);

		final ResponseEntity<ProductDTO> responseEntity = productServiceWs.updateProduct(productDTO);

		assertEquals(newQuantinty, responseEntity.getBody().getQuantityInStock());
		assertEquals(newUnitPrice, responseEntity.getBody().getUnitPrice());

	}

	@SuppressWarnings("rawtypes")
	@Test
	public void shouldDeleteProduct() {

		final Long id = 3L;

		final ResponseEntity<ProductDTO> productResponseEntity = productQueryServiceWs.getProductById(id);

		ResponseEntity response = productServiceWs.deleteProduct(id);

		assertEquals(ResponseEntity.ok().build().getStatusCode(),
				response.getStatusCode());

		try {
			productServiceWs.updateProduct(productResponseEntity.getBody());
		} catch (BusinessException e) {
			assertEquals("Product with ID: " + id + " does not exist!", e.getMessage());
		}
	}

	/*
	@Test
	public void shouldUpdateProductStock() {

		final Long id = 1L;

		final ResponseEntity<ProductDTO> productResponseEntity = productQueryServiceWs.getProductById(id);

		final ProductDTO product = productResponseEntity.getBody();

		final double newQuantinty = 50;

		final double expectedQuantity = newQuantinty + product.getQuantityInStock();

		final ResponseEntity<ProductDTO> updatedProduct = productServiceWs.updateProductStock(id, newQuantinty, true);

		assertEquals(expectedQuantity, updatedProduct.getBody().getQuantityInStock());

	}

	@Test
	public void shouldNotUpdateProductStock() {

		final Long id = 1L;

		final ResponseEntity<ProductDTO> productResponseEntity = productQueryServiceWs.getProductById(id);

		final ProductDTO product = productResponseEntity.getBody();

		final double newQuantinty = 101;

		try {
			productServiceWs.updateProductStock(id, newQuantinty, false);
		} catch (BusinessException e) {
			assertEquals("The available quantity: " + product.getQuantityInStock() + " in Product with ID: " + id
					+ " and name: " + product.getName() + " is less than the quantity you intend to reduce: "
					+ newQuantinty, e.getMessage());
		}

	}*/

}
