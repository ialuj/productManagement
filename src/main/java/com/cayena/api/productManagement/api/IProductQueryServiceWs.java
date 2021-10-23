package com.cayena.api.productManagement.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.cayena.api.productManagement.dto.ProductDTO;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes endpoints for getting a product by id, and
 *         listing all products
 *
 */
public interface IProductQueryServiceWs {

	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id);

	public ResponseEntity<List<ProductDTO>> listAllProducts();

}
