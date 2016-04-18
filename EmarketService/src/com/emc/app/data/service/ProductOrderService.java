package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.ProductOrder;

public interface ProductOrderService {
	public void save(ProductOrder productOrder);
	public void update(ProductOrder productOrder);
	public List<ProductOrder> getProductOrders(int first, int max);
	public void delete(ProductOrder productOrder);
}
