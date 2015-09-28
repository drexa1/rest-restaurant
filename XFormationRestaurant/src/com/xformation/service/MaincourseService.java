package com.xformation.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xformation.model.Product;
import com.xformation.business.ProductBO;

@Path("/maincourses")
@SuppressWarnings({"unchecked"})
public class MaincourseService {

	ProductBO business = new ProductBO();

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllMaincourse() throws Exception {
        return business.findAllMaincourse();
    }
	
	@GET
	@Path("/cuisine/{cuisine}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getMaincourseByCuisine(@PathParam("cuisine") String value) throws Exception {
		return business.findMaincourseByColumn("cuisine", value);
    }
	
	@GET
	@Path("/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getMaincourseByOid(@PathParam("oid") String value) throws Exception {
		return business.findMaincourseByColumn("oid", value);
    }
	
	@GET
	@Path("name/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public String getNameByOid(@PathParam("oid") String value) throws Exception {
		Product maincourse = (Product)(business.findMaincourseByColumn("oid", value)).toArray()[0];
		return maincourse.getName();
	}
	
	@GET
	@Path("price/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Float getPriceByOid(@PathParam("oid") String value) throws Exception {
		Product maincourse = (Product)(business.findMaincourseByColumn("oid", value)).toArray()[0];
		return maincourse.getPrice();
	}

}