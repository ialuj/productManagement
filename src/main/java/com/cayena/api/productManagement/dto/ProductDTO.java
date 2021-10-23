package com.cayena.api.productManagement.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cayena.api.productManagement.model.entity.Product;
import com.cayena.api.productManagement.model.entity.Supplier;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 *         Data transfer object - we'll use it to return response to client
 *         request, such as, queries, updates, registration and so on
 *
 */
public class ProductDTO {

	private Long id;

	@NotBlank(message = "Name can not be blank")
	private String name;

	@NotNull(message = "Quantity in stock is required")
	private double quantityInStock;

	@NotNull(message = "Unit Price is required")
	private double unitPrice;

	@NotNull(message = "Supplier ID is required")
	private Long supplierId;

	private Supplier supplier;

	@NotBlank(message = "Creation date can not be blank")
	private Date creationDate;

	private Date lastUpdateDate;

	public ProductDTO() {
		super();
	}
	
	public ProductDTO(final Product product) {
		setId(product.getId());
		setName(product.getName());
		setQuantityInStock(product.getQuantityInStock());
		setUnitPrice(product.getUnitPrice());
		setSupplier(product.getSupplier());
		setCreationDate(product.getCreationDate());
		setLastUpdateDate(product.getLastUpdateDate());
	}

	public ProductDTO(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice, Supplier supplier,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
		this.supplier = supplier;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public ProductDTO(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice,
			@NotNull(message = "Supplier ID is required") Long supplierId,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
		this.supplierId = supplierId;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public ProductDTO(Long id, @NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice, Supplier supplier,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.id = id;
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
		this.supplier = supplier;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(double quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.setSupplierId(supplier == null ? null : supplier.getId());
		this.supplier = supplier;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Product toProductNewInstance() {
		return new Product(this.getName(), this.getQuantityInStock(), this.getUnitPrice(), this.getSupplierId(),
				this.getCreationDate(), this.getLastUpdateDate());
	}

	public Product toProduct() {
		if(this.getSupplier()==null) {
			return new Product(this.getId(), this.getName(), this.getQuantityInStock(), this.getUnitPrice(),
					this.getSupplierId(), this.getCreationDate(), this.getLastUpdateDate());
		}
		return new Product(this.getId(), this.getName(), this.getQuantityInStock(), this.getUnitPrice(),
				this.getSupplier(), this.getCreationDate(), this.getLastUpdateDate());
	}

	public ProductDTO fromProduct(final Product product) {
		return new ProductDTO(product.getId(), product.getName(), product.getQuantityInStock(), product.getUnitPrice(),
				product.getSupplier(), product.getCreationDate(), product.getLastUpdateDate());
	}

}
