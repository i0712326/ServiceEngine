package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.emc.app.cont.aware.WebApplicationContext;
import com.emc.app.data.service.ProductImgService;
import com.emc.app.entity.Entity;
import com.emc.app.entity.ProductImg;
@Component
public class ProductImgPoiImp implements ProductImgPoi {
	private ProductImgService service = (ProductImgService) WebApplicationContext.getBean("productImgService");
	@Override
	public Response save(ProductImg productImg) {
		service.save(productImg);
		return Response.status(200).entity(new Entity("200","Success")).build();
	}

	@Override
	public Response getProductImg(String id) {
		List<ProductImg> list = service.getProductImg(id);
		return Response.status(200).entity(list).build();
	}

}
