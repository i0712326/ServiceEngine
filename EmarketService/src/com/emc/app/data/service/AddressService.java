package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Address;

public interface AddressService {
	public void save(Address address);
	public void update(Address address);
	public List<Address> getAddress(int first, int max);
	public void delete(Address address);
}
