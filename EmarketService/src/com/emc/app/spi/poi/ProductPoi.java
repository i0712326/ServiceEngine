package com.emc.app.spi.poi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.emc.app.entity.Product;
@Path("product")
public interface ProductPoi {
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(Product product);
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Product product);
	
	@GET
	@Path("/search/{keyWord}/{first}/{max}")
	@Produces("application/json")
	public Response searchProduct(@PathParam("keyWord")String keyWord, @PathParam("first") int first, @PathParam("max") int max);
	
	@GET
	@Path("/get/{id}")
	@Produces("application/json")
	public Response getProduct(@PathParam("id") String id);
	
	@GET
	@Path("get/{mcId}/{id}")
	@Produces("application/json")
	public Response getProductByMc(@PathParam("mcId")String mcId, @PathParam("id")String id);
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getProducts(@QueryParam("first") int first, @QueryParam("max") int max);
	
	@GET
	@Path("/getByRank")
	@Produces("application/json")
	public Response getProductByRank(@QueryParam("first") int first, @QueryParam("max") int max);
	
	@GET
	@Path("/getByMcc")
	@Produces("application/json")
	public Response getProductMcc(@QueryParam("mcc")String mcc, @QueryParam("review") int review, @QueryParam("first") int first, @QueryParam("max") int max);
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	@Produces("applicaiton/json")
	public Response delete(Product product);
	
}
