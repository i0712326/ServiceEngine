package com.emc.app.entity;

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
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTID")
	private int id;
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	@JsonIgnore
	@Column(name="PASSWD", nullable=false)
	private String passwd;
	@Column(name="CUSTNAME")
	private String name;
	@Column(name="CUSTLAST")
	private String last;
	@Column(name="TEL", nullable=false)
	private String tel;
	@ManyToOne
	@JoinColumn(name="ADDRTBL_ADDRID",referencedColumnName="ADDRID")
	private Address address;
	@ManyToOne
	@JoinColumn(name="ROLETBL_ROLEID",referencedColumnName="ROLEID")
	private Role role;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
