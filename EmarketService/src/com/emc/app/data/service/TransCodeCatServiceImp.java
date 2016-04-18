package com.emc.app.data.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import com.emc.app.dao.TransCodeCatDao;
import com.emc.app.entity.TransCodeCat;
@Service("transCodeCatService")
public class TransCodeCatServiceImp implements TransCodeCatService {
	private Logger logger = Logger.getLogger(getClass());
	private TransCodeCatDao transCodeCatDao;
	public void setTransCodeCatDao(TransCodeCatDao transCodeCatDao){
		this.transCodeCatDao = transCodeCatDao;
	}
	@Override
	public void save(TransCodeCat transCodeCat) {
		try {
			transCodeCatDao.save(transCodeCat);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save tcc",e);
		}
	}

	@Override
	public TransCodeCat getTransCodeCat(String tcc) {
		try {
			return transCodeCatDao.getTransCodeCat(tcc);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get tcc", e);
			return new TransCodeCat();
		}
	}

}
