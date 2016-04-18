package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Order;

public interface OrderService {
	public void save(Order order);
	public void update(Order order);
	public List<Order> getOrders(int first, int max);
	public void delete(Order order);
}
