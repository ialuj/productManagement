package com.cayena.api.productManagement.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Jose Julai Ritsure
 *
 *         Class that represents a Product Object
 *
 */

@Entity
@Table(name = "PRODUCT", uniqueConstraints = {
		@UniqueConstraint(name = "UC_PRODUCT_SUPPLIER", columnNames = { "NAME", "SUPPLIER_ID", "DATE_OF_CREATION" }) })
public class Product implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5575704342594111710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, insertable = false)
	private Long id;

	@NotBlank(message = "Name can not be blank")
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull(message = "Quantity in stock is required")
	@Column(name = "QUANTINTY", nullable = false)
	private double quantityInStock;

	@NotNull(message = "Unit Price is required")
	@Column(name = "UNIT_PRICE", nullable = false)
	private double unitPrice;

	@NotNull(message = "Supplier ID is required")
	@Column(name = "SUPPLIER_ID", nullable = false, insertable = false, updatable = false)
	private Long supplierId;

	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
	private Supplier supplier;

	@NotNull(message = "DATE OF CREATION is required")
	@Column(name = "DATE_OF_CREATION", nullable = false)
	private Date creationDate;

	@Column(name = "DATE_OF_LAST_UPDATE", nullable = true)
	private Date lastUpdateDate;

	public Product() {
		super();
	}

	public Product(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice, Supplier supplier,
			@NotNull(message = "DATE OF CREATION is required") Date creationDate) {
		super();
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
		this.supplier = supplier;
		this.creationDate = creationDate;
	}

	public Product(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice, Supplier supplier) {
		super();
		this.setName(name);
		this.setQuantityInStock(quantityInStock);
		this.setUnitPrice(unitPrice);
		this.setSupplier(supplier);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public Product(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice, Supplier supplier,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setName(name);
		this.setQuantityInStock(quantityInStock);
		this.setUnitPrice(unitPrice);
		this.setSupplier(supplier);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public Product(@NotBlank(message = "Name can not be blank") String name,
			@NotNull(message = "Quantity in stock is required") double quantityInStock,
			@NotNull(message = "Unit Price is required") double unitPrice,
			@NotNull(message = "Supplier ID is required") Long supplierId,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setName(name);
		this.setQuantityInStock(quantityInStock);
		this.setUnitPrice(unitPrice);
		this.setSupplierId(supplierId);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public Product(Long id, @NotBlank(message = "Name can not be blank") String name,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantityInStock);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(quantityInStock) != Double.doubleToLongBits(other.quantityInStock))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantityInStock=" + quantityInStock + ", unitPrice="
				+ unitPrice + ", supplierId=" + supplierId + ", supplier=" + supplier + ", creationDate=" + creationDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

}
