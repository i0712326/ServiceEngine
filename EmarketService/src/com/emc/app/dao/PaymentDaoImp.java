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

import com.emc.app.entity.Payment;
@Repository("paymentDao")
public class PaymentDaoImp implements PaymentDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(Payment payment) throws SQLException, HibernateException {
		hibernateTemplate.save(payment);
	}

	@Override
	public void update(Payment payment) throws SQLException, HibernateException {
		hibernateTemplate.update(payment);
	}

	@Override
	public List<Payment> getPayments(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Payment.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}

	@Override
	public void delete(Payment payment) throws SQLException, HibernateException {
		hibernateTemplate.delete(payment);
	}
	
	private List<Payment> toList(final List<?> beans){
		if(beans==null) return new ArrayList<Payment>();
		if(beans.isEmpty()) return new ArrayList<Payment>();
		int size = beans.size();
		Payment[] list = new Payment[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
