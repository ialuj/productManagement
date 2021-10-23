package com.cayena.api.productManagement.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cayena.api.productManagement.dto.ProductDTO;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes endpoints for saving, updating and deleting a
 *         product
 *
 */
public interface IProductServiceWs {

	@PostMapping
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO);

	@PutMapping
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO);

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable("id") Long id);

	@PatchMapping("{id}")
	public ResponseEntity<ProductDTO> updateProductStock(@PathVariable Long id,
			@RequestBody Map<Object, Object> fields);

}
