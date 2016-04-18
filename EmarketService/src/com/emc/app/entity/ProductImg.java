package com.emc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRDIMGTBL")
public class ProductImg {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMGID")
	int id;
	@Column(name="IMGNAME")
	private String picName;
	@ManyToOne
	@JoinColumn(name="PRDTBL_PRDID",referencedColumnName="PRDID")
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
