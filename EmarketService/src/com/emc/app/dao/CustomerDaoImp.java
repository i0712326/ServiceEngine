package com.emc.app.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emc.app.entity.Customer;
@Repository("customerDao")
public class CustomerDaoImp implements CustomerDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(Customer customer) throws SQLException, HibernateException {
		hibernateTemplate.save(customer);
	}
	
	@Override
	public Customer getCustomer(final Customer customer) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<Customer>(){
			@Override
			public Customer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Customer c where c.email = :email";
				Query query = session.createQuery(hql);
				query.setString("email", customer.getEmail());
				return (Customer) query.uniqueResult();
			}
			
		});
	}
	@Override
	public void update(Customer customer) throws SQLException,
			HibernateException {
		hibernateTemplate.update(customer);
	}

	@Override
	public List<Customer> getCustomers(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		return toList(hibernateTemplate.findByCriteria(criteria, first, max));
	}

	@Override
	public void delete(Customer customer) throws SQLException,
			HibernateException {
		hibernateTemplate.delete(customer);
	}
	
	private List<Customer> toList(final List<?> beans){
		if(beans==null) return new ArrayList<Customer>();
		if(beans.isEmpty()) return new ArrayList<Customer>();
		int size = beans.size();
		Customer[] list = new Customer[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
