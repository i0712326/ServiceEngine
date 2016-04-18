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

import com.emc.app.entity.Address;
@Repository("addressDao")
public class AddressDaoImp implements AddressDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Transactional
	@Override
	public void save(Address address) throws SQLException, HibernateException {
		hibernateTemplate.save(address);
	}
	@Transactional
	@Override
	public void update(Address address) throws SQLException, HibernateException {
		hibernateTemplate.update(address);
	}
	@Transactional
	@Override
	public List<Address> getAddress(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Address.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}
	@Transactional
	@Override
	public void delete(Address address) throws SQLException, HibernateException {
		hibernateTemplate.delete(address);
	}
	
	private List<Address> toList(final List<?> beans){
		if(beans==null) return new ArrayList<Address>();
		if(beans.isEmpty()) return new ArrayList<Address>();
		int size = beans.size();
		Address[] list = new Address[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}

}
