package com.cayena.api.productManagement.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.repository.ProductRepository;

/**
 * 
 * @author Jose Julai Ritsure
 *
 * Product Query Services Implementation
 *
 */
@Service
public class ProductQueryServiceImpl implements IProductQueryService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(Long id) {
		if(!doesProductExist(id)) {
			throw new BusinessException("Product with ID: " + id + " does not exist!");
		}
		Optional<Product> optProduct = productRepository.findById(id);
		return optProduct.get();
	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public boolean doesProductExist(final Long id) {
		Optional<Product> optProduct = productRepository.findById(id);
		return optProduct.isPresent();
	}

}
