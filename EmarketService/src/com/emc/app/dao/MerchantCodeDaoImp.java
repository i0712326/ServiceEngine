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

import com.emc.app.entity.MerchantCode;
@Repository("merchantCodeDao")
public class MerchantCodeDaoImp implements MerchantCodeDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public MerchantCodeDaoImp() {
		super();
	}

	@Override
	public void save(MerchantCode merchantType) throws SQLException,
			HibernateException {
		hibernateTemplate.save(merchantType);
	}

	@Override
	public void delete(MerchantCode merchantType) throws SQLException,
			HibernateException {
		hibernateTemplate.delete(merchantType);
	}
	
	@Override
	public MerchantCode getMerchantCode(final MerchantCode merchantCode)
			throws SQLException, HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<MerchantCode>(){
			@Override
			public MerchantCode doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("getMerchantCode");
				query.setString("mcc", merchantCode.getMcc());
				return (MerchantCode) query.uniqueResult();
			}
			
		});
	}
	
	@Override
	public List<MerchantCode> getMerchantCodes(final int first, final int max) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<List<MerchantCode>>(){

			@Override
			public List<MerchantCode> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("getMerchantCodes");
				query.setFirstResult(first);
				query.setMaxResults(max);
				return toList(query.list());
			}
			
		});
	}
	private List<MerchantCode> toList(final List<?> beans){
		if(beans==null) return null;
		if(beans.isEmpty()) return null;
		int size = beans.size();
		MerchantCode[] list = new MerchantCode[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
