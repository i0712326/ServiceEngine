package com.emc.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="MCGTBL")
public class MerchantCatGrp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MCGID")
	private int id;
	@Column(name="NOTE")
	private String note;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="merchantCatGrp", cascade=CascadeType.ALL)
	private List<MerchantCode> merchantCodes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
