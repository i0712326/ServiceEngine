package com.emc.app.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.app.entity.Order;

@Repository("orderDao")
public class OrderDaoImp implements OrderDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Transactional
	@Override
	public void save(Order order) throws SQLException, HibernateException {
		hibernateTemplate.save(order);
	}
	@Transactional
	@Override
	public void update(Order order) throws SQLException, HibernateException {
		hibernateTemplate.update(order);
	}
	@Transactional
	@Override
	public List<Order> getOrders(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}
	@Transactional
	@Override
	public void delete(Order order) throws SQLException, HibernateException {
		hibernateTemplate.delete(order);
	}
	private List<Order> toList(final List<?> beans){
		if(beans==null) return new ArrayList<Order>();
		if(beans.isEmpty()) return new ArrayList<Order>();
		int size = beans.size();
		Order[] list = new Order[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
	
}
