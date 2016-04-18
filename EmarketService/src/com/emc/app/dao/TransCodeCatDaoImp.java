package com.emc.app.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emc.app.entity.TransCodeCat;

@Repository("transCodeCatDao")
public class TransCodeCatDaoImp implements TransCodeCatDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(TransCodeCat transCodeCat) throws HibernateException,
			SQLException {
		hibernateTemplate.save(transCodeCat);
	}

	@Override
	public TransCodeCat getTransCodeCat(final String tcc) throws HibernateException,
			SQLException {
		return hibernateTemplate.execute(new HibernateCallback<TransCodeCat>(){
			@Override
			public TransCodeCat doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TransCodeCat tc where tc.tcc = :tcc";
				Query query = session.createQuery(hql);
				query.setString("tcc", tcc);
				return (TransCodeCat) query.uniqueResult();
			}
			
		});
	}

}
