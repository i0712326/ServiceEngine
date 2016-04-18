package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Merchant;

public interface MerchantDao {
	public void save(Merchant merchant) throws SQLException, HibernateException;
	public void delete(Merchant merchant) throws SQLException, HibernateException;
	public Merchant getMerchant(Merchant merchant) throws SQLException, HibernateException;
	public List<Merchant> getMerchants(Merchant merchant) throws SQLException, HibernateException;
}
