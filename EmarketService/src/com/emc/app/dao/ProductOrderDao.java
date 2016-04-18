package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.ProductOrder;

public interface ProductOrderDao {
	public void save(ProductOrder productOrder) throws SQLException, HibernateException;
	public void update(ProductOrder productOrder) throws SQLException, HibernateException;
	public List<ProductOrder> getProductOrders(int first, int max) throws SQLException, HibernateException;
	public void delete(ProductOrder productOrder) throws SQLException, HibernateException;
}
