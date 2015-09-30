package com.xformation.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xformation.business.ProductBO;
import com.xformation.model.Order;

@Path("/orders")
@SuppressWarnings({"unchecked"})
public class OrderService {

	ProductBO business = new ProductBO();

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrder() throws Exception {
        return business.findAllOrder();
    }
	
	@GET
	@Path("/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrderByOid(@PathParam("oid") String value) throws Exception {
		return business.findOrderByColumn("oid", value);
    }
	
	@GET
	@Path("/new/{desc}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
	public Integer newOrder(@PathParam("desc") String desc, @PathParam("price") float price) throws Exception {
		return business.addOrder(desc, price);
	}

}