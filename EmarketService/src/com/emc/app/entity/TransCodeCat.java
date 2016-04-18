package com.emc.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
@Entity
@Table(name="TCCTBL")
public class TransCodeCat implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TCC")
	private String tcc;
	@Column(name="NOTE")
	private String note;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="transCodeCat")
	private List<MerchantCode> merchantCodes;
	public String getTcc() {
		return tcc;
	}
	public void setTcc(String tcc) {
		this.tcc = tcc;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@JsonIgnore
	public List<MerchantCode> getMerchantCodes() {
		return merchantCodes;
	}
	public void setMerchantCodes(List<MerchantCode> merchantCodes) {
		this.merchantCodes = merchantCodes;
	}
}
