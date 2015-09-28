package com.xformation.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xformation.business.ProductBO;
import com.xformation.model.Drink;

@Path("/drinks")
@SuppressWarnings({"unchecked"})
public class DrinkService {
	
	ProductBO business = new ProductBO();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Drink> getAllDrinks() throws Exception {
        return business.findAllDrink();
    }
	
	@GET
	@Path("/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Drink> getDrinkByOid(@PathParam("oid") String value) throws Exception {
		return business.findDrinkByColumn("oid", value);
    }
	
	@GET
	@Path("name/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public String getNameByOid(@PathParam("oid") String value) throws Exception {
		Drink drink = (Drink)(business.findDrinkByColumn("oid", value)).toArray()[0];
		return drink.getName();
	}
	
	@GET
	@Path("price/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Float getPriceByOid(@PathParam("oid") String value) throws Exception {
		Drink drink = (Drink)(business.findDrinkByColumn("oid", value)).toArray()[0];
		return drink.getPrice();
	}
	
}