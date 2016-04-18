package com.emc.app.spi.poi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.emc.app.entity.ProductImg;

@Path("productImg")
public interface ProductImgPoi {
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(ProductImg productImg);
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getProductImg(@QueryParam("id") String id);
}
