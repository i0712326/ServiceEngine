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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
@Entity
@Table(name="MCCTBL")
public class MerchantCode implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MCC")
	private String mcc;
	@Column(name="NOTE")
	private String note;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="merchantCode", cascade=CascadeType.ALL)
	private List<Merchant> merchants;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TCCTBL_TCC")
	private TransCodeCat transCodeCat;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="MCGTBL_MCGID")
	private MerchantCatGrp merchantCatGrp;
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@JsonIgnore
	public List<Merchant> getMerchants() {
		return merchants;
	}
	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}
	public TransCodeCat getTransCodeCat() {
		return transCodeCat;
	}
	public void setTransCodeCat(TransCodeCat transCodeCat) {
		this.transCodeCat = transCodeCat;
	}
	public MerchantCatGrp getMerchantCatGrp() {
		return merchantCatGrp;
	}
	public void setMerchantCatGrp(MerchantCatGrp merchantCatGrp) {
		this.merchantCatGrp = merchantCatGrp;
	}
}
