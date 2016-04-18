package com.emc.app.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.app.dao.ProductImgDao;
import com.emc.app.entity.ProductImg;
@Service("productImgService")
public class ProductImgServiceImp implements ProductImgService {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ProductImgDao productImgDao;
	public void setProductImgDao(ProductImgDao productImgDao){
		this.productImgDao = productImgDao;
	}
	@Override
	public void save(ProductImg productImg) {
		try {
			productImgDao.save(productImg);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to save product img",e);
		}
	}

	@Override
	public List<ProductImg> getProductImg(String id) {
		try {
			return productImgDao.getProductImg(id);
		} catch (HibernateException | SQLException e) {
			logger.debug("Exception occured while try to get product images",e);
			return new ArrayList<ProductImg>();
		}
	}

}
