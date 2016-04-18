package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.ProductOrderDao;
import com.emc.app.entity.ProductOrder;
@Service("productOrderService")
public class ProductOrderServiceImp implements ProductOrderService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ProductOrderDao productOrderDao;
	public void setProductOrderDao(ProductOrderDao productOrderDao){
		this.productOrderDao = productOrderDao;
	}
	@Override
	public void save(ProductOrder productOrder) {
		try {
			productOrderDao.save(productOrder);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save product order", e);
		}
	}

	@Override
	public void update(ProductOrder productOrder) {
		try {
			productOrderDao.update(productOrder);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update product order",e);
		}

	}

	@Override
	public List<ProductOrder> getProductOrders(int first, int max) {
		try {
			return productOrderDao.getProductOrders(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get product order", e);
			return new ArrayList<ProductOrder>();
		}
	}

	@Override
	public void delete(ProductOrder productOrder) {
		try {
			productOrderDao.delete(productOrder);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete product order data",e);
		}
	}

}
