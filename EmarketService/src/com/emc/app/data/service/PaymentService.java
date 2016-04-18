package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Payment;

public interface PaymentService {
	public void save(Payment payment);
	public void update(Payment payment);
	public List<Payment> getPayments(int first, int max);
	public void delete(Payment payment);
}
