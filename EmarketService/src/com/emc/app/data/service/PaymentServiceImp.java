package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.PaymentDao;
import com.emc.app.entity.Payment;
@Service("paymentService")
public class PaymentServiceImp implements PaymentService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private PaymentDao paymentDao;
	public void setPaymentDao(PaymentDao paymentDao){
		this.paymentDao = paymentDao;
	}
	@Override
	public void save(Payment payment) {
		try {
			paymentDao.save(payment);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save payment data",e);
		}
	}

	@Override
	public void update(Payment payment) {
		try {
			paymentDao.update(payment);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try update payment", e);
		}
	}

	@Override
	public List<Payment> getPayments(int first, int max) {
		try {
			return paymentDao.getPayments(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get paymet data", e);
			return new ArrayList<Payment>();
		}
	}

	@Override
	public void delete(Payment payment) {
		try {
			paymentDao.delete(payment);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete payment data",e);
		}
		
	}

}
