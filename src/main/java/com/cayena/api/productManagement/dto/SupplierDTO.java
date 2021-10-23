package com.cayena.api.productManagement.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

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
public class SupplierDTO {

	private Long id;

	@NotBlank(message = "Name can not be blank")
	private String name;

	@NotBlank(message = "Creation date can not be blank")
	private Date creationDate;

	private Date lastUpdateDate;

	private List<Product> products;

	public SupplierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SupplierDTO(final Supplier supplier) {
		this.setId(supplier.getId());
		this.setName(supplier.getName());
		this.setCreationDate(supplier.getCreationDate());
		this.setLastUpdateDate(supplier.getLastUpdateDate());
	}

	public SupplierDTO(@NotBlank(message = "Name can not be blank") String name,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setName(name);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public SupplierDTO(Long id, @NotBlank(message = "Name can not be blank") String name,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setId(id);
		this.setName(name);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public SupplierDTO(Long id, @NotBlank(message = "Name can not be blank") String name,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate,
			List<Product> products) {
		super();
		this.setId(id);
		this.setName(name);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
		this.setProducts(products);
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Supplier toNewSupllierInstance() {
		return new Supplier(this.getName(), this.getCreationDate(),
				this.getLastUpdateDate());
	}

	public Supplier toSupllier() {
		return new Supplier(this.getId(), this.getName(), this.getCreationDate(),
				this.getLastUpdateDate());
	}

}
