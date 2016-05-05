package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emc.app.cont.aware.WebApplicationContext;
import com.emc.app.data.service.ProductService;
import com.emc.app.entity.Entity;
import com.emc.app.entity.Product;
import com.emc.app.entity.ProductImg;
@Component("ProductPoiImp")
@Scope("prototype")
public class ProductPoiImp implements ProductPoi {
	private ProductService productService = (ProductService) WebApplicationContext.getBean("productService");
	
	@Override
	public Response save(Product product) {
		List<ProductImg> list = product.getProductImgs();
		for(ProductImg prdImg : list)
			prdImg.setProduct(product);
		productService.save(product);
		return Response.status(200).entity(new Entity("200","Success")).build();
	}

	@Override
	public Response update(Product product) {
		productService.update(product);
		return Response.status(200).entity(new Entity("200","Success")).build();
	}
	
	@Override
	public Response searchProduct(String keyWord, int first, int max) {
		List<Product> list =productService.getProductByKeyWord("%"+keyWord+"%", first, max);
		return Response.ok().entity(list).build();
	}
	@Override
	public Response getProduct(String id) {
		Product product = productService.getProduct(id);
		return Response.ok().entity(product).build();
	}
	
	@Override
	public Response getProductByMc(String mcId, String id) {
		Product product = productService.getProductByMc(mcId, id);
		return Response.ok().entity(product).build();
	}

	@Override
	public Response getProducts(int first, int max) {
		List<Product> list = productService.getProducts(first, max);
		return Response.status(200).entity(list).build();
	}
	@Override
	public Response getProductByRank(int first, int max) {
		List<Product> list = productService.getProductByRank(5, first, max);
		return Response.status(200).entity(list).build();
	}
	@Override
	public Response getProductMcc(String mcc, int review, int first, int max) {
		List<Product> list = productService.getProductByMcc(mcc, review, first, max);
		return Response.status(200).entity(list).build();
	}
	@Override
	public Response delete(Product product) {
		productService.delete(product);
		return Response.status(200).build();
	}

}
