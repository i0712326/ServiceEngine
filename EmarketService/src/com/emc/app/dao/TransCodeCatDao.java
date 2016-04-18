package com.emc.app.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.emc.app.entity.TransCodeCat;

public interface TransCodeCatDao {
	public void save(TransCodeCat transCodeCat) throws HibernateException, SQLException;
	public TransCodeCat getTransCodeCat(String tcc) throws HibernateException, SQLException;
}
