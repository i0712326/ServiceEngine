package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Address;

public interface AddressDao {
	public void save(Address address) throws SQLException, HibernateException;
	public void update(Address address) throws SQLException, HibernateException;
	public List<Address> getAddress(int first, int max) throws SQLException, HibernateException;
	public void delete(Address address) throws SQLException, HibernateException;
}
