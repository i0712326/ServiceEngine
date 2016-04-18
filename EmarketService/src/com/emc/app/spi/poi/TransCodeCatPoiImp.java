package com.emc.app.spi.poi;

import javax.ws.rs.core.Response;

import com.emc.app.cont.aware.WebApplicationContext;
import com.emc.app.data.service.TransCodeCatService;
import com.emc.app.entity.Entity;
import com.emc.app.entity.TransCodeCat;

public class TransCodeCatPoiImp implements TransCodeCatPoi {
	private TransCodeCatService transCodeCatService = (TransCodeCatService) WebApplicationContext.getBean("transCodeCatService");;
	@Override
	public Response save(TransCodeCat transCodeCat) {
		transCodeCatService.save(transCodeCat);
		return Response.ok(new Entity("200","Successful Add TCC")).build();
	}

	@Override
	public Response getTransCodeCat(String tcc) {
		TransCodeCat transCodeCat = transCodeCatService.getTransCodeCat(tcc);
		return Response.status(200).entity(transCodeCat).build();
	}

}
