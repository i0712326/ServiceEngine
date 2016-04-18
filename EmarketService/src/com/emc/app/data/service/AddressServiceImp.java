package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.AddressDao;
import com.emc.app.entity.Address;
@Service("addressService")
public class AddressServiceImp implements AddressService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private AddressDao addressDao;
	public void setAddressDao(AddressDao addressDao){
		this.addressDao = addressDao;
	}
	@Override
	public void save(Address address) {
		try {
			addressDao.save(address);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save address", e);
		}
	}

	@Override
	public void update(Address address) {
		try {
			addressDao.update(address);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update address data",e);
		}
	}

	@Override
	public List<Address> getAddress(int first, int max) {
		try {
			return addressDao.getAddress(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get address data", e);
			return new ArrayList<Address>();
		}
	}

	@Override
	public void delete(Address address) {
		try {
			addressDao.delete(address);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete address data",e);
		}

	}

}
