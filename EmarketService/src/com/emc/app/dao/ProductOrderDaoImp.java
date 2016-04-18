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

import com.emc.app.entity.ProductOrder;
@Repository("productOrderDao")
public class ProductOrderDaoImp implements ProductOrderDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Transactional
	@Override
	public void save(ProductOrder productOrder) throws SQLException,
			HibernateException {
		hibernateTemplate.save(productOrder);
	}
	@Transactional
	@Override
	public void update(ProductOrder productOrder) throws SQLException,
			HibernateException {
		hibernateTemplate.update(productOrder);

	}
	@Transactional
	@Override
	public List<ProductOrder> getProductOrders(int first, int max)
			throws SQLException, HibernateException {
		 DetachedCriteria criteria = DetachedCriteria.forClass(ProductOrder.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}
	@Transactional
	@Override
	public void delete(ProductOrder productOrder) throws SQLException,
			HibernateException {
		hibernateTemplate.delete(productOrder);
	}
	private List<ProductOrder> toList(final List<?> beans){
		if(beans==null) return new ArrayList<ProductOrder>();
		if(beans.isEmpty()) return new ArrayList<ProductOrder>();
		int size = beans.size();
		ProductOrder[] list = new ProductOrder[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
