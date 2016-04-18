package com.emc.app.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.app.entity.Product;
@Repository("productDao")
public class ProductDaoImp implements ProductDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Transactional
	@Override
	public void save(Product product) throws SQLException, HibernateException {
		hibernateTemplate.save(product);
	}
	@Transactional
	@Override
	public void delete(Product product) throws SQLException, HibernateException {
		hibernateTemplate.delete(product);
	}
	@Transactional
	@Override
	public void update(Product product) throws SQLException, HibernateException {
		hibernateTemplate.update(product);
	}
	@Transactional
	@Override
	public Product getProduct(final Product product) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<Product>(){

			@Override
			public Product doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("getProduct");
				query.setString("id", product.getId());
				return (Product) query.uniqueResult();
			}
			
		});
	}
	@Transactional
	@Override
	public List<Product> getProducts(int first, int max) throws SQLException,
			HibernateException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class).addOrder(Order.asc("id"));
		return toList(hibernateTemplate.findByCriteria(criteria,first,max));
	}
	
	@Transactional
	@Override
	public List<Product> getProductsRank(final int rate, final int first, final int max)
			throws SQLException, HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<List<Product>>(){
			@Override
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Product p where p.review >= :rate order by p.review";
				Query query = session.createQuery(hql);
				query.setInteger("rate", rate);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return toList(query.list());
			}
			
		});
	}
	@Transactional
	@Override
	public List<Product> getProductsMcc(final String mcc, final int review, final int first, final int max)
			throws SQLException, HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<List<Product>>(){

			@Override
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select p from Product as p inner join p.merchant as mc inner join mc.merchantCode as mcc "
						+"where mcc.mcc = :mcc and p.review >= :review order by p.review";
				Query query = session.createQuery(hql);
				query.setString("mcc", mcc);
				query.setInteger("review", review);
				query.setFirstResult(first);
				query.setMaxResults(max);
				List<Product> list = toList(query.list());
				return list;
			}
			
		});
		
	}
	@Transactional
	@Override
	public List<Product> getProductByKeyWord(final String keyWord, final int first, final int max)
			throws SQLException, HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<List<Product>>(){

			@Override
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select p from Product as p inner join p.merchant as mc inner join mc.merchantCode as mcc "
						+"where mcc.note like :keyWdrd order by p.review desc";
				Query query = session.createQuery(hql);
				query.setString("keyWord", keyWord);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return toList(query.list());
			}
			
		});
		
	}

	@Transactional
	@Override
	public Product getProductByMc(final String mcId, final String id) throws SQLException,
			HibernateException {
		return hibernateTemplate.execute(new HibernateCallback<Product>(){

			@Override
			public Product doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select p from Product as p inner join p.merchant as m where p.id = :id and m.mcId = :mcId ";
				Query query = session.createQuery(hql);
				query.setString("id", id);
				query.setString("mcId", mcId);
				return (Product) query.uniqueResult();
			}
			
		});
	}

	private List<Product> toList(final List<?> beans){
		if(beans==null) return null;
		if(beans.isEmpty()) return null;
		int size = beans.size();
		Product[] list = new Product[size];
		list = beans.toArray(list);
		return Arrays.asList(list);
	}
}
