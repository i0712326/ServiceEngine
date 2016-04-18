package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.app.data.service.AddressService;
import com.emc.app.entity.Address;
import com.emc.app.entity.Entity;
@Component("addressPoi")
public class AddressPoiImp implements AddressPoi {
	@Autowired
	private AddressService addressService;
	public void setAddressService(AddressService addressService){
		this.addressService = addressService;
	}
	@Override
	public Response save(Address address) {
		addressService.save(address);
		return Response.status(200).entity(new Entity("200","Successufl")).build();
	}

	@Override
	public Response update(Address address) {
		addressService.update(address);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

	@Override
	public Response getAddress(int first, int max) {
		List<Address> list = addressService.getAddress(first, max);
		return Response.status(200).entity(list).build();
	}

	@Override
	public Response delete(Address address) {
		addressService.delete(address);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

}
