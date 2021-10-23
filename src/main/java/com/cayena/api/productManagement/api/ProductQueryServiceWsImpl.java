package com.cayena.api.productManagement.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cayena.api.productManagement.dto.ProductDTO;
import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.service.IProductQueryService;

/**
 * 
 * @author Jose Julai Ritsure
 *
 *         Interface that implements query product endpoints
 *
 */

@RestController
@RequestMapping("api/v1/productManagement")
public class ProductQueryServiceWsImpl implements IProductQueryServiceWs {

	@Autowired
	private IProductQueryService productQueryService;

	@SuppressWarnings("unchecked")
	@Override
	@GetMapping("/id")
	public ResponseEntity<ProductDTO> getProductById(Long id) {

		try {
			final Product product = productQueryService.getProductById(id);

			final ProductDTO dto = new ProductDTO(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return (ResponseEntity<ProductDTO>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> listAllProducts() {

		try {
			final List<Product> products = productQueryService.listAllProducts();

			final List<ProductDTO> dtos = products.stream().map(ProductDTO::new).collect(Collectors.toList());

			ResponseEntity<List<ProductDTO>> response = ResponseEntity.ok(dtos);

			return response;

		} catch (

		BusinessException e) {
			return (ResponseEntity<List<ProductDTO>>) ResponseEntity.status(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return (ResponseEntity<List<ProductDTO>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

}
