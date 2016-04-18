package com.emc.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductOrderId implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="PRDTBL_PRDID", referencedColumnName="PRDID")
	private Product product;
	@ManyToOne
	@JoinColumn(name="ORDTBL_ORDID", referencedColumnName="ORDID")
	private Order order;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}	
}
