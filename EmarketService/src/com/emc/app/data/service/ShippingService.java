package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Shipping;

public interface ShippingService {
	public void save(Shipping shipping);
	public void update(Shipping shipping);
	public List<Shipping> getShippings(int first, int max);
	public void delete(Shipping shipping);
}
