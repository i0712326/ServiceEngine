package com.emc.app.spi.poi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.emc.app.entity.Customer;

@Path("customer")
public interface CustomerPoi {
	@POST
	@Path("/save")
	@Produces("application/json")
	@Consumes("application/json")
	public Response save(Customer customer);
	@PUT
	@Path("/update")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Customer customer);
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response getCustomer(Customer customer);
	@POST
	@Path("/authen")
	@Produces("application/json")
	public Response authen(@FormParam("email") String email, @FormParam("passwd") String passwd);
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getCustomers(@QueryParam("first") int first, @QueryParam("max") int max);
	@DELETE
	@Path("/delete")
	@Produces("application/json")
	@Consumes("application/json")
	public Response delete(Customer customer);
}
