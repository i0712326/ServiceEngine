package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.CustomerDao;
import com.emc.app.entity.Customer;
@Service("customerService")
public class CustomerServiceImp implements CustomerService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao = customerDao;
	}
	@Override
	public void save(Customer customer) {
		try {
			customerDao.save(customer);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save customer data",e);
		}
	}
	
	@Override
	public Customer getCustomer(Customer customer) {
		try {
			return customerDao.getCustomer(customer);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get customer password", e);
			return new Customer();
		}
	}
	@Override
	public void update(Customer customer) {
		try {
			customerDao.update(customer);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update customer data", e);
		}	
	}

	@Override
	public List<Customer> getCustomers(int first, int max) {
		try {
			return customerDao.getCustomers(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get data for customer", e);
			return new ArrayList<Customer>();
		}
	}

	@Override
	public void delete(Customer customer) {
		try {
			customerDao.delete(customer);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete customer data",e);
		}
		
		
	}

}
