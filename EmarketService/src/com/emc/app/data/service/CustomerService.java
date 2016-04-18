package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Customer;

public interface CustomerService {
	public void save(Customer customer);
	public void update(Customer customer);
	public Customer getCustomer(Customer customer);
	public List<Customer> getCustomers(int first, int max);
	public void delete(Customer customer);
}
