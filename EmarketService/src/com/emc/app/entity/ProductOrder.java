package com.emc.app.entity;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="PRDTBL_has_ORDTBL")
public class ProductOrder {
	@EmbeddedId
	private ProductOrderId productOrderId;
	@Column(name="QTY")
	private int quantity;
	@Column(name="PRIC")
	private float price;
	public ProductOrderId getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(ProductOrderId productOrderId) {
		this.productOrderId = productOrderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
