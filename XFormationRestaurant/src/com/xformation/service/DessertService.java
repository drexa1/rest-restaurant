package com.xformation.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xformation.business.ProductBO;
import com.xformation.model.Product;

@Path("/desserts")
@SuppressWarnings({"unchecked"})
public class DessertService {
	
	ProductBO business = new ProductBO();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllDessert() throws Exception {
        return business.findAllDessert();
    }
	
	@GET
	@Path("/cuisine/{cuisine}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getDessertByCuisine(@PathParam("cuisine") String value) throws Exception {
		return business.findDessertByColumn("cuisine", value);
    }
	
	@GET
	@Path("/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getDessertByOid(@PathParam("oid") String value) throws Exception {
		return business.findDessertByColumn("oid", value);
    }
	
	@GET
	@Path("name/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public String getNameByOid(@PathParam("oid") String value) throws Exception {
		Product dessert = (Product)(business.findDessertByColumn("oid", value)).toArray()[0];
		return dessert.getName();
	}
	
	@GET
	@Path("price/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Float getPriceByOid(@PathParam("oid") String value) throws Exception {
		Product dessert = (Product)(business.findDessertByColumn("oid", value)).toArray()[0];
		return dessert.getPrice();
	}
	
}