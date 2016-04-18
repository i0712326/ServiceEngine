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
@Table(name="PRDTBL")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PRDID")
	private String id;
	@Column(name="PRDNAME")
	private String name;
	@Column(name="PRDPRICE")
	private float price;
	@Column(name="STOCK")
	private int stock;
	@Column(name="PRDSHRDES")
	private String shDes;
	@Column(name="PRDLONDES")
	private String loDes;
	@Column(name="PRDIMG")
	private String img;
	@Column(name="PRDTHUMB")
	private String thumb;
	@Column(name="REVIEW")
	private int review;
	@Column(name="RATE")
	private int rate;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="MCTBL_MCID")
	private Merchant merchant;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<ProductOrder> productOrders;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="product", cascade=CascadeType.ALL)
	private List<ProductImg> productImgs;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comments;
	public Product() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getShDes() {
		return shDes;
	}
	public void setShDes(String shDes) {
		this.shDes = shDes;
	}
	public String getLoDes() {
		return loDes;
	}
	public void setLoDes(String loDes) {
		this.loDes = loDes;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	@JsonIgnore
	public List<ProductOrder> getProductOrders() {
		return productOrders;
	}
	public void setProductOrders(List<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
	@JsonIgnore
	public List<ProductImg> getProductImgs() {
		return productImgs;
	}
	public void setProductImgs(List<ProductImg> productImgs) {
		this.productImgs = productImgs;
	}
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
