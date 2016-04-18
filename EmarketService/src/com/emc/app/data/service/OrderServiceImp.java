package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.OrderDao;
import com.emc.app.entity.Order;
@Service("orderService")
public class OrderServiceImp implements OrderService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao){
		this.orderDao = orderDao;
	}
	@Override
	public void save(Order order) {
		try {
			orderDao.save(order);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save order data", e);
		}
	}

	@Override
	public void update(Order order) {
		try {
			orderDao.update(order);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update order data", e);
		}

	}

	@Override
	public List<Order> getOrders(int first, int max) {
		try {
			return orderDao.getOrders(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get order data",e);
			return new ArrayList<Order>();
		}
	}

	@Override
	public void delete(Order order) {
		try {
			orderDao.delete(order);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete order data",e);
			e.printStackTrace();
		}
	}

}
