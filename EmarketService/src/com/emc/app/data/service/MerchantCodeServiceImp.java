package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.MerchantCodeDao;
import com.emc.app.entity.MerchantCode;
@Service("merchantCodeService")
public class MerchantCodeServiceImp implements MerchantCodeService{
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private MerchantCodeDao merchantCodeDao;
	public void setMerchantCodeDao(MerchantCodeDao merchantCodeDao){
		this.merchantCodeDao = merchantCodeDao;
	}
	@Override
	public void save(MerchantCode merchantType) {
		try {
			merchantCodeDao.save(merchantType);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save merchant type information", e);
		}
		
	}

	@Override
	public void delete(MerchantCode merchantType) {
		try {
			merchantCodeDao.delete(merchantType);
		} catch (HibernateException | SQLException e) {
			
		}
		
	}
	
	@Override
	public MerchantCode getMerchantCode(MerchantCode merchantCode) {
		try {
			return merchantCodeDao.getMerchantCode(merchantCode);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get merchant code information", e);
			return null;
		}
	}
	
	@Override
	public List<MerchantCode> getMerchantCodes(int first, int max) {
		try {
			return merchantCodeDao.getMerchantCodes(first, max);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save merchant code information", e);
			return null;
		}
	}

}
