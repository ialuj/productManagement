package com.cayena.api.productManagement.api;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cayena.api.productManagement.dto.ProductDTO;
import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.entity.Supplier;
import com.cayena.api.productManagement.model.service.IProductQueryService;
import com.cayena.api.productManagement.model.service.IProductService;
import com.cayena.api.productManagement.model.service.ISupplierQueryService;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes endpoints for creating, updating and deleting
 *         products
 *
 */

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = { "*" })
public class ProductServiceWsImpl implements IProductServiceWs {

	@Autowired
	private IProductService productService;

	@Autowired
	private ISupplierQueryService supplierQueryService;
	
	@Autowired
	private IProductQueryService productQueryService;

	@Override
	public ResponseEntity<ProductDTO> saveProduct(ProductDTO productDTO) {
		try {
			final Product product = productDTO.toProductNewInstance();

			final Supplier supplier = supplierQueryService.getSupplierById(product.getSupplierId());
			product.setSupplier(supplier);

			final Product savedProduct = productService.saveProduct(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(new ProductDTO(savedProduct));

			return response;
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
		try {
			final Product product = productDTO.toProduct();

			final Supplier supplier = supplierQueryService.getSupplierById(product.getSupplierId());
			product.setSupplier(supplier);

			final Product updatedProduct = productService.updateProduct(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(new ProductDTO(updatedProduct));

			return response;
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity deleteProduct(Long id) {
		try {

			productService.deleteProduct(id);

			return ResponseEntity.ok("Product with ID: " + id + " was deleted successfully!");
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@Override
	public ResponseEntity<ProductDTO> updateProductStock(@PathVariable Long id,
			@RequestBody Map<Object, Object> fields) {
		try {
			
			final Product product = productQueryService.getProductById(id);
			
			boolean isAdd = (boolean) fields.get("isAdd");
			fields.remove("isAdd");
						
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Product.class, (String) key);
				field.setAccessible(true);
				double newStock = 0;
				
				double newQuant = Double.parseDouble(value.toString());

				if (isAdd) {
					newStock = product.getQuantityInStock() + newQuant;
					product.setQuantityInStock(newStock);
				}

				if (product.getQuantityInStock() < 0 || product.getQuantityInStock() < newQuant) {
					throw new BusinessException("The available quantity: " + product.getQuantityInStock()
							+ " in Product with ID: " + id + " and name: " + product.getName()
							+ " is less than the quantity you intend to reduce: " + newQuant);
				}
				newStock = product.getQuantityInStock() - newQuant;
				ReflectionUtils.setField(field, product, newStock);
			});
			
			final Product updatedProduct = productService.updateProduct(product);

			ResponseEntity<ProductDTO> response = ResponseEntity.ok(new ProductDTO(updatedProduct));
			
			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
