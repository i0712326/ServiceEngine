package com.emc.app.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.app.entity.Merchant;
@Repository("merchantDao")
public class MerchantDaoImp implements MerchantDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public MerchantDaoImp() {
		super();
	}
	@Transactional
	@Override
	public void save(Merchant merchant) throws SQLException, HibernateException {
		hibernateTemplate.save(merchant);
	}
	@Transactional
	@Override
	public void delete(Merchant merchant) throws SQLException,
			HibernateException {
		hibernateTemplate.delete(merchant);
	}
	@Transactional
	@Override
	public Merchant getMerchant(final Merchant merchant) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<Merchant>(){

			@Override
			public Merchant doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("getMerchant");
				query.setString("mcId", merchant.getMcId());
				return (Merchant) query.uniqueResult();
			}
			
		});
	}
	@Transactional
	@Override
	public List<Merchant> getMerchants(final Merchant merchant) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<List<Merchant>>(){

			@Override
			public List<Merchant> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("getMerchants");
				query.setString("mcId", merchant.getMcId());
				query.setString("name", merchant.getName());
				query.setString("email", merchant.getEmail());
				query.setString("fax", merchant.getFax());
				return toList(query.list());
			}
			
		});
	}
	private List<Merchant> toList(final List<?> beans){
		if(beans==null) return null;
		if(beans.isEmpty()) return null;
		int size = beans.size();
		Merchant[] list = new Merchant[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
