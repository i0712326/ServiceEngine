package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.app.dao.MerchantDao;
import com.emc.app.entity.Merchant;
@Service("merchantService")
public class MerchantServiceImp implements MerchantService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private MerchantDao merchantDao;
	public void setMerchantDao(MerchantDao merchantDao){
		this.merchantDao = merchantDao;
	}
	@Transactional
	@Override
	public void save(Merchant merchant) {
		try {
			merchantDao.save(merchant);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exceptional occurred while try to save merchant data",e);
		}
	}
	@Transactional
	@Override
	public void delete(Merchant merchant) {
		try {
			merchantDao.delete(merchant);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exceptional occurred while try to delete merchant data",e);
		}
	}
	@Transactional
	@Override
	public Merchant getMerchant(Merchant merchant) {
		try {
			return merchantDao.getMerchant(merchant);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exceptional occurred while try to get merchant data",e);
			return null;
		}
	}
	@Transactional
	@Override
	public List<Merchant> getMerchants(Merchant merchant) {
		try {
			return merchantDao.getMerchants(merchant);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exceptional occurred while try to save merchant data",e);
			return null;
		}
	}

}
