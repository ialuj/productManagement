package com.cayena.api.productManagement.model.service;

import com.cayena.api.productManagement.model.entity.Product;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Interface that exposes product creation, update and delete services
 *
 */
public interface IProductService {

	public Product saveProduct(final Product product);

	public Product updateProduct(final Product product);

	public void deleteProduct(final Long id);

	public Product updateProductStock(final Long id, final double quantity, final boolean isAdd);

}
