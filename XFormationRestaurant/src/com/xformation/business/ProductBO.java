package com.xformation.business;

import java.util.List;

import com.xformation.model.Order;
import com.xformation.persistence.BackofficequeueDAO;
import com.xformation.persistence.DessertDAO;
import com.xformation.persistence.DrinkDAO;
import com.xformation.persistence.MaincourseDAO;

@SuppressWarnings("rawtypes")
public class ProductBO {

	private MaincourseDAO maincourseDAO = new MaincourseDAO();
	private DessertDAO dessertDAO = new DessertDAO();
	private DrinkDAO drinkDAO = new DrinkDAO();
	private BackofficequeueDAO orderDAO = new BackofficequeueDAO();
	
	public List findMaincourseByColumn(String columnId, String value) throws Exception {
		return maincourseDAO.findByColumn(columnId, value);
	}
	public List findAllMaincourse() throws Exception {
		return maincourseDAO.findAll();
	}
	
	public List findDessertByColumn(String columnId, String value) throws Exception {
		return dessertDAO.findByColumn(columnId, value);
	}
	public List findAllDessert() throws Exception {
		return dessertDAO.findAll();
	}
	
	public List findDrinkByColumn(String columnId, String value) throws Exception {
		return drinkDAO.findByColumn(columnId, value);
	}
	public List findAllDrink() throws Exception {
		return drinkDAO.findAll();
	}
	
	public List findOrderByColumn(String columnId, String value) throws Exception {
		return orderDAO.findByColumn(columnId, value);
	}
	public List findAllOrder() throws Exception {
		return orderDAO.findAll();
	}	
	public Integer addOrder(String desc, float price) throws Exception {
		Integer result = new Integer(0);
		Order bluemonday = new Order();
		//Find the last order number
		List orders = orderDAO.findAllOrderBy("oid", false);
		if(orders!=null && !orders.isEmpty()) {
			Order lastorder = (Order)orders.get(0);
			bluemonday.setOid(lastorder.getOid() + 1);
		} else {
			bluemonday.setOid(1);
		}
		bluemonday.setDesc(desc);
		bluemonday.setPrice(price);
		//Return the last order number
		if(orderDAO.add(bluemonday)) {
			result = bluemonday.getOid();
		}
		return result;
	}
	
	
}