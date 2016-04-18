package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Product;

public interface ProductService {
	public void save(Product product);
	public void delete(Product product);
	public Product getProduct(String id);
	public Product getProductByMc(String mcId, String id);
	public List<Product> getProducts(int max, int first);
	public void update(Product product);
	public List<Product> getProductByRank(int rank, int first, int max);
	public List<Product> getProductByMcc(String note, int review, int first, int max);
	public List<Product> getProductByKeyWord(String keyWord, int first, int max);
	
}
