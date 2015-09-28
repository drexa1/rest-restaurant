package com.xformation.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.xformation.model.Drink;

@SuppressWarnings("rawtypes")
public class DrinkDAO extends ConnectionDAO {
	
	private final String TABLE = "DRINK";
	private final String DEFAULT_ORDERBY = "oid";
	
	/**
	 * Collects rows of a table filtered by a certain field.
	 * @param columnId
	 * @param value
	 * @throws Exception
	 * @return List
	 */
	public List findByColumn(String columnId, String value) throws Exception {
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Drink> result = new ArrayList<Drink>();
		try {
			c = getConnection();						
			String sql = "SELECT * FROM " + TABLE + " WHERE " + columnId + " = ? ";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, value);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setOid(rs.getInt("oid"));
				drink.setName(rs.getString("name"));
				drink.setPrice(rs.getFloat("price"));
				result.add(drink);
			}
	        rs.close();
	        stmt.close();
	        //OSIV c.close();
		} catch (Exception e) {
			throw new Exception(e.getClass().getName() + ".findByColumn(): " + e.getMessage());
		}
		return result;
	}
	
	@Override
	public List findAll() throws Exception {
		return findAllOrderBy(DEFAULT_ORDERBY, true);
	}
	
	/**
	 * Collects all the rows of a table ordered by field.
	 * @param table
	 * @param fieldToOrder
	 * @param ascendent
	 * @throws Exception
	 * @return List
	*/
	@Override
	public List findAllOrderBy(String fieldToOrder, boolean ascendent) throws Exception {
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Drink> result = new ArrayList<Drink>();
		try {
			c = getConnection();						
			String sql = "SELECT * FROM " + TABLE + " ORDER BY " + fieldToOrder + (!ascendent ? "DESC" : "");
			stmt = c.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setOid(rs.getInt("oid"));
				drink.setName(rs.getString("name"));
				drink.setPrice(rs.getFloat("price"));
				result.add(drink);
			}
	        rs.close();
	        stmt.close();
	        //OSIV c.close();
		} catch (Exception e) {
			throw new Exception(e.getClass().getName() + ".findAllOrderBy(): " + e.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean exists(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean add(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int findCount(String table) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean remove(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeByColumn(String columnId, String value)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(String table) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}