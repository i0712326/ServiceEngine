package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Component;

import com.emc.app.cont.aware.WebApplicationContext;
import com.emc.app.data.service.CustomerService;
import com.emc.app.entity.Customer;
import com.emc.app.entity.Entity;

@Component("customerPoi")
public class CustomerPoiImp implements CustomerPoi {
	private CustomerService customerService = (CustomerService) WebApplicationContext.getBean("customerService");
	@Override
	public Response save(Customer customer) {
		String passwd = customer.getPasswd();
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		passwd = passwordEncryptor.encryptPassword(passwd);
		customer.setPasswd(passwd);
		customerService.save(customer);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

	@Override
	public Response update(Customer customer) {
		customerService.update(customer);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}
	
	@Override
	public Response getCustomer(Customer customer) {
		Customer cust = customerService.getCustomer(customer);
		return Response.status(200).entity(cust).build();
	}
	
	@Override
	public Response authen(String email, String passwd) {
		Customer cust = new Customer();
		cust.setEmail(email);
		cust.setPasswd(passwd);
		Customer customer = customerService.getCustomer(cust);
		String encryptedPasswd = customer.getPasswd();
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		if (passwordEncryptor.checkPassword(passwd, encryptedPasswd))
			return Response.ok(new Entity("200","Successful")).build();
		return Response.status(403).entity(new Entity("403","Authentication Failed")).build();
	}

	@Override
	public Response getCustomers(int first, int max) {
		List<Customer> list = customerService.getCustomers(first, max);
		return Response.status(200).entity(list).build();
	}

	@Override
	public Response delete(Customer customer) {
		customerService.delete(customer);
		return Response.status(200).entity(new Entity("200","Successful")).build();
	}

}
