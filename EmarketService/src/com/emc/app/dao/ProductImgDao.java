package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.ProductImg;

public interface ProductImgDao {
	public void save(ProductImg productImg) throws HibernateException, SQLException;
	public List<ProductImg> getProductImg(String prdId) throws HibernateException, SQLException;
}
