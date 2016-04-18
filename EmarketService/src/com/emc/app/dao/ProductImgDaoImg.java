package com.emc.app.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emc.app.entity.ProductImg;

@Repository("productImgDao")
public class ProductImgDaoImg implements ProductImgDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(ProductImg productImg) throws HibernateException,
			SQLException {
		hibernateTemplate.save(productImg);
	}

	@Override
	public List<ProductImg> getProductImg(String prdId)
			throws HibernateException, SQLException {
		String hql = "select pi from ProductImg pi inner join pi.product p where p.id = :prdId ";
		return toList(hibernateTemplate.findByNamedParam(hql, "prdId", prdId));
	}
	private List<ProductImg> toList(final List<?> beans){
		if(beans==null) return new ArrayList<ProductImg>();
		if(beans.isEmpty()) return new ArrayList<ProductImg>();
		int size = beans.size();
		ProductImg[] list = new ProductImg[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
