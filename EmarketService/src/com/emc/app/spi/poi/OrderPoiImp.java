package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.app.data.service.OrderService;
import com.emc.app.entity.Order;
@Component("orderPoi")
public class OrderPoiImp implements OrderPoi {
	@Autowired
	private OrderService orderService;
	public void setOrderService(OrderService orderService){
		this.orderService = orderService;
	}
	@Override
	public Response save(Order order) {
		orderService.save(order);
		return Response.status(200).build();
	}

	@Override
	public Response update(Order order) {
		orderService.update(order);
		return Response.status(200).build();
	}

	@Override
	public Response getOrder(int first, int max) {
		List<Order> list = orderService.getOrders(first, max);
		return Response.status(200).entity(list).build();
	}

	@Override
	public Response delete(Order order) {
		orderService.delete(order);
		return Response.status(200).build();
	}

}
