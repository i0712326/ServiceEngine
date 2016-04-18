package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.app.data.service.ShippingService;
import com.emc.app.entity.Entity;
import com.emc.app.entity.Shipping;
@Component("shippingPoi")
public class ShippingPoiImp implements ShippingPoi {
	@Autowired
	private ShippingService shippingService;
	public void setShippingService(ShippingService shippingService){
		this.shippingService = shippingService;
	}
	@Override
	public Response save(Shipping shipping) {
		shippingService.save(shipping);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

	@Override
	public Response update(Shipping shipping) {
		shippingService.update(shipping);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

	@Override
	public Response get(int first, int max) {
		List<Shipping> list = shippingService.getShippings(first, max);
		return Response.status(200).entity(list).build();
	}

	@Override
	public Response delete(Shipping shipping) {
		shippingService.delete(shipping);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

}
