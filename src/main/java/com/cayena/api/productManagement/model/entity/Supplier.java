package com.cayena.api.productManagement.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "SUPPLIER", uniqueConstraints = { @UniqueConstraint(name ="UC_SUPPLIER_NAME", columnNames = { "NAME" }) })
public class Supplier implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7703225523936954676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, insertable = false)
	private Long id;

	@NotBlank(message = "Name can not be blank")
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull(message = "DATE OF CREATION is required")
	@Column(name = "DATE_OF_CREATION", nullable = false)
	private Date creationDate;

	@Column(name = "DATE_OF_LAST_UPDATE", nullable = true)
	private Date lastUpdateDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
	private List<Product> products = new ArrayList<Product>(0);

	public Supplier() {
		super();
	}

	public Supplier(@NotBlank(message = "Name can not be blank") String name,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setName(name);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
	}

	public Supplier(Long id, @NotBlank(message = "Name can not be blank") String name,
			@NotBlank(message = "Creation date can not be blank") Date creationDate, Date lastUpdateDate) {
		super();
		this.setId(id);
		this.setName(name);
		this.setCreationDate(creationDate);
		this.setLastUpdateDate(lastUpdateDate);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Supplier other = (Supplier) obj;
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
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", lastUpdateDate="
				+ lastUpdateDate + ", products=" + products + "]";
	}

}
