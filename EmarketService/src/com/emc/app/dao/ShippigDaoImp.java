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

import com.emc.app.entity.Shipping;

@Repository("shippingDao")
public class ShippigDaoImp implements ShippingDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Transactional
	@Override
	public void save(Shipping shipping) throws SQLException, HibernateException {
		hibernateTemplate.save(shipping);
	}
	@Transactional
	@Override
	public void update(Shipping shipping) throws SQLException,
			HibernateException {
		hibernateTemplate.update(shipping);
	}
	@Transactional
	@Override
	public List<Shipping> getShippings(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Shipping.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}
	@Transactional
	@Override
	public void delete(Shipping shipping) throws SQLException,
			HibernateException {
		hibernateTemplate.delete(shipping);
	}
	private List<Shipping> toList(final List<?> beans){
		if(beans==null) return new ArrayList<Shipping>();
		if(beans.isEmpty()) return new ArrayList<Shipping>();
		int size = beans.size();
		Shipping[] list = new Shipping[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
