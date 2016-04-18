package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.ProductImg;

public interface ProductImgService {
	public void save(ProductImg productImg);
	public List<ProductImg> getProductImg(String id);
}
