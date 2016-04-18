package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.MerchantCode;

public interface MerchantCodeDao {
	public void save(MerchantCode merchantType) throws SQLException, HibernateException;
	public void delete(MerchantCode merchantType) throws SQLException, HibernateException;
	public MerchantCode getMerchantCode(MerchantCode merchantCode) throws SQLException, HibernateException;
	public List<MerchantCode> getMerchantCodes(int first, int max) throws SQLException, HibernateException;
	
}
