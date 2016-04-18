package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Order;

public interface OrderDao {
	public void save(Order order) throws SQLException, HibernateException;
	public void update(Order order) throws SQLException, HibernateException;
	public List<Order> getOrders(int first, int max) throws SQLException, HibernateException;
	public void delete(Order order) throws SQLException, HibernateException;
}
