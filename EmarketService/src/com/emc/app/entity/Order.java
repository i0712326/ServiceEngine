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
@Table(name="ORDTBL")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDID")
	private int id;
	@Column(name="ORDDATE")
	private Date date;
	@Column(name="TOTAL")
	private float total;
	@Column(name="NUM")
	private int num;
	@Column(name="PAYDATE")
	private Date payDate;
	@ManyToOne
	@JoinColumn(name="PAYMENT_PMID")
	private Payment payment;
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
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
