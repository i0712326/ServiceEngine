package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Shipping;

public interface ShippingDao {
	public void save(Shipping shipping) throws SQLException, HibernateException;
	public void update(Shipping shipping) throws SQLException, HibernateException;
	public List<Shipping> getShippings(int first, int max) throws SQLException, HibernateException;
	public void delete(Shipping shipping) throws SQLException, HibernateException;
}
