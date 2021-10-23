package com.cayena.api.productManagement.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO);

	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO);

	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteProduct(@PathVariable("id") Long id);
	
	public ResponseEntity<ProductDTO> updateProductStock(@PathVariable("id") Long id, @PathVariable("id") double quantity, @PathVariable("signal") boolean isAdd);

}
