package com.cayena.api.productManagement.model.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.repository.ProductRepository;

/**
 * 
 * @author Jose Julai Ritsure
 *
 *         Product Services Implementation
 *
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IProductQueryService productQueryService;

	@Override
	public Product saveProduct(Product product) {
		try {
			return productRepository.save(product);
		} catch (ConstraintViolationException e) {
			throw new BusinessException("Verify the submitted information: " + product);
		}
	}

	@Override
	public Product updateProduct(Product product) {
		if (!productQueryService.doesProductExist(product.getId())) {
			throw new BusinessException("Product with ID: " + product.getId() + " does not exist!");
		}
		try {
			return productRepository.save(product);
		} catch (ConstraintViolationException e) {
			throw new BusinessException("Verify the submitted information: " + product);
		}
	}

	@Override
	public void deleteProduct(Long id) {

		if (!productQueryService.doesProductExist(id)) {
			throw new BusinessException("Product with ID: " + id + " does not exist!");
		}
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProductStock(final Long id, final double quantity, final boolean isAdd) {

		if (!productQueryService.doesProductExist(id)) {
			throw new BusinessException("Product with ID: " + id + " does not exist!");
		}

		Product product = productQueryService.getProductById(id);

		double newStock = 0;

		if (isAdd) {
			newStock = product.getQuantityInStock() + quantity;
			product.setQuantityInStock(newStock);
			return product;
		}

		if (product.getQuantityInStock() < 0 || product.getQuantityInStock() < quantity) {
			throw new BusinessException("The available quantity: " + product.getQuantityInStock()
					+ " in Product with ID: " + id + " and name: " + product.getName()
					+ " is less than the quantity you intend to reduce: " + quantity);
		}

		newStock = product.getQuantityInStock() - quantity;
		product.setQuantityInStock(newStock);
		return product;
	}

}
