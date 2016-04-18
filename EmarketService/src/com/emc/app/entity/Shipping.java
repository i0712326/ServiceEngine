package com.emc.app.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="")
public class Shipping {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHIPID")
	private int id;
	@Column(name="SHIPDATE")
	private Date date;
	@Column(name="SHIPTIME")
	private Timestamp time;
	@Column(name="STATUS")
	private String status;
	@Column(name="REMARK")
	private String remark;
	@OneToOne
	@JoinColumn(name="ORDTBL_ORDID")
	private Order order;
	@ManyToOne
	@JoinColumn(name="ADDRTBL_ADDRID")
	private Address address;
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
