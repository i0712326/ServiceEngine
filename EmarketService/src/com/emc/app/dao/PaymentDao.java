package com.emc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.emc.app.entity.Payment;

public interface PaymentDao {
	public void save(Payment payment) throws SQLException, HibernateException;
	public void update(Payment payment) throws SQLException, HibernateException;
	public List<Payment> getPayments(int first, int max) throws SQLException, HibernateException;
	public void delete(Payment payment) throws SQLException, HibernateException;
}
