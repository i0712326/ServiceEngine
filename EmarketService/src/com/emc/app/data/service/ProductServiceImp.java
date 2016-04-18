package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.ProductDao;
import com.emc.app.entity.Product;
@Service("productService")
public class ProductServiceImp implements ProductService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}
	public ProductServiceImp() {
		super();
	}

	@Override
	public void save(Product product) {
		try {
			productDao.save(product);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save product information", e);
		}
	}

	@Override
	public void delete(Product product) {
		try {
			productDao.delete(product);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete product information", e);
		}
	}
	
	@Override
	public Product getProduct(String id) {
		try {
			Product product = new Product();
			product.setId(id);
			return productDao.getProduct(product);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to retreive product information",e);
			return new Product();
		}
	}
	
	@Override
	public Product getProductByMc(String mcId, String id) {
		try {
			return productDao.getProductByMc(mcId, id);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get product detail from mcid and id", e);
			return new Product();
		}
	}
	@Override
	public List<Product> getProducts(int first, int max) {
		try {
			return productDao.getProducts(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to retreive product information",e);
			return null;
		}
	}

	@Override
	public void update(Product product) {
		try {
			productDao.update(product);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update product information", e);
		}
	}
	@Override
	public List<Product> getProductByRank(int rank, int first, int max) {
		
		try {
			return productDao.getProductsRank(rank, first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get popular product",e);
			return new ArrayList<Product>();
		}
	}
	@Override
	public List<Product> getProductByMcc(String mcc, int review, int first, int max) {
		try {
			return productDao.getProductsMcc(mcc, review, first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get product by group",e);
			return new ArrayList<Product>();
		}
	}
	@Override
	public List<Product> getProductByKeyWord(String keyWord, int first, int max) {
		try{
			return productDao.getProductByKeyWord(keyWord, first, max);
		}
		catch(HibernateException | SQLException e){
			return new ArrayList<Product>();
		}
	}
	
}
