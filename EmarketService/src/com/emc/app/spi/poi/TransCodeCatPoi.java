package com.emc.app.spi.poi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.emc.app.entity.TransCodeCat;
@Path("transCodeCate")
public interface TransCodeCatPoi {
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(TransCodeCat transCodeCat);
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getTransCodeCat(@QueryParam("tcc") String tcc);
}
