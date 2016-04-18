package com.emc.app.spi.poi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.emc.app.entity.Shipping;
@Path("shpping")
public interface ShippingPoi {
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(Shipping shipping);
	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Shipping shipping);
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response get(@QueryParam("first") int first, @QueryParam("max") int max);
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Shipping shipping);
}
