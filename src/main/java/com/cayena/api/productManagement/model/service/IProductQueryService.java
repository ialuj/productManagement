package com.cayena.api.productManagement.model.service;

import java.util.List;

import com.cayena.api.productManagement.model.entity.Product;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface that exposes product query services
 *
 */
public interface IProductQueryService {
	
	public Product getProductById(final Long id);
	
	public List<Product> listAllProducts();

	public boolean doesProductExist(Long id);

}
