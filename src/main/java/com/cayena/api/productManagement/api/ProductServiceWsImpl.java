package com.cayena.api.productManagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cayena.api.productManagement.dto.ProductDTO;
import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.service.IProductService;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes endpoints for creating, updating and deleting
 *         products
 *
 */

@RestController
@RequestMapping("api/v1/productManagement")
public class ProductServiceWsImpl implements IProductServiceWs {

	@Autowired
	private IProductService productService;

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<ProductDTO> saveProduct(ProductDTO productDTO) {
		try {
			final Product product = productDTO.toProductNewInstance();

			final Product savedProduct = productService.saveProduct(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(new ProductDTO(savedProduct));

			return response;
		} catch (BusinessException e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
		try {
			final Product product = productDTO.toProductNewInstance();

			final Product updatedProduct = productService.updateProduct(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(new ProductDTO(updatedProduct));

			return response;
		} catch (BusinessException e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NO_CONTENT);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity deleteProduct(Long id) {
		try {

			productService.deleteProduct(id);

			return ResponseEntity.ok("Product with ID: " + id + " was deleted successfully!");
		} catch (BusinessException e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NO_CONTENT);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<ProductDTO> updateProductStock(Long id, double quantity, boolean isAdd) {
		try {
			final Product product = productService.updateProductStock(id, quantity, isAdd);

			final ProductDTO dto = new ProductDTO(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

}
