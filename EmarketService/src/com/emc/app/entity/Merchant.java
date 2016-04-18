package com.emc.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="MCTBL")
public class Merchant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="MCID",length=12)
	private String mcId;
	@Column(name="MCNAME", nullable=false)
	private String name;
	@Column(name="TEL", nullable=false)
	private String tel;
	@Column(name="FAX", nullable=false)
	private String fax;
	@Column(name="EMAIL", nullable=false)
	private String email;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="MCTYPE_MCC")
	private MerchantCode merchantCode;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="merchant",cascade=CascadeType.ALL)
	private List<Product> products;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRTBL_ADDRID", referencedColumnName="ADDRID")
	private Address address;
	public String getMcId() {
		return mcId;
	}
	public void setMcId(String mcId) {
		this.mcId = mcId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MerchantCode getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(MerchantCode merchantCode) {
		this.merchantCode = merchantCode;
	}
	@JsonIgnore
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
