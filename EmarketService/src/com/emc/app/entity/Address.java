package com.emc.app.entity;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRTBL")
public class Address {
	@Id
	@Column(name="ADDRID")
	private String addrId;
	@Column(name="STREET")
	private String street;
	@Column(name="VILLE")
	private String ville;
	@Column(name="DISTR")
	private String distr;
	@Column(name="PROVI")
	private String provi;
	public String getAddrId() {
		return addrId;
	}
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDistr() {
		return distr;
	}
	public void setDistr(String distr) {
		this.distr = distr;
	}
	public String getProvi() {
		return provi;
	}
	public void setProvi(String provi) {
		this.provi = provi;
	}
	
	
}
