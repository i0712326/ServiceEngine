package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.ShippingDao;
import com.emc.app.entity.Shipping;
@Service("shippingService")
public class ShippigServiceImp implements ShippingService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ShippingDao shippingDao;
	public void setShippingDao(ShippingDao shippingDao){
		this.shippingDao = shippingDao;
	}
	@Override
	public void save(Shipping shipping) {
		try {
			shippingDao.save(shipping);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save shipping", e);
		}
	}

	@Override
	public void update(Shipping shipping) {
		try {
			shippingDao.update(shipping);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to update shipping data", e);
		}
	}

	@Override
	public List<Shipping> getShippings(int first, int max) {
		try {
			return shippingDao.getShippings(first, max);
		} catch (HibernateException | SQLException e) {
			return new ArrayList<Shipping>();
		}
	}

	@Override
	public void delete(Shipping shipping) {
		try {
			shippingDao.delete(shipping);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to delete shipping data",e);
		}
	}

}
