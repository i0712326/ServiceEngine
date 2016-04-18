package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Customer;

public interface CustomerDao {
	public void save(Customer customer) throws SQLException, HibernateException;
	public Customer getCustomer(Customer customer) throws SQLException, HibernateException; 
	public void update(Customer customer) throws SQLException, HibernateException;
	public List<Customer> getCustomers(int first, int max) throws SQLException, HibernateException;
	public void delete(Customer customer) throws SQLException, HibernateException;
}
