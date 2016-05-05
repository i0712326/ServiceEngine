package com.emc.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="COMMENTTBL")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMID")
	private int id;
	@Column(name="COMDATE")
	private Date date = new Date(new java.util.Date().getTime());
	@Column(name="RATE")
	private int rate;
	@Column(name="COMMENT")
	private String comment;
	@ManyToOne
	@JoinColumn(name="CUSTOMER_CUSTID",referencedColumnName="CUSTID")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="PRDTBL_PRDID",referencedColumnName="PRDID")
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
