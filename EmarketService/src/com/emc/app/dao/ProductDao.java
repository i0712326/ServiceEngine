package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Product;

public interface ProductDao {
	public void save(Product product) throws SQLException, HibernateException;
	public void update(Product product) throws SQLException, HibernateException;
	public void delete(Product product) throws SQLException, HibernateException;
	public Product getProduct(Product product) throws SQLException, HibernateException;
	public List<Product> getProducts(int first, int max) throws SQLException, HibernateException;
	public List<Product> getProductsRank(int review, int first, int max) throws SQLException, HibernateException;
	public List<Product> getProductsMcc(String mcc, int review, int first, int max) throws SQLException, HibernateException;
	public List<Product> getProductByKeyWord(String keyWord, int first, int max) throws SQLException, HibernateException;
	public Product getProductByMc(String mcId, String id) throws SQLException, HibernateException;
}
