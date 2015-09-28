package com.xformation.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.xformation.model.Order;

@SuppressWarnings("rawtypes")
public class BackofficequeueDAO extends ConnectionDAO {
	
	private final String TABLE = "BACKOFFICEQUEUE";
	private final String DEFAULT_ORDERBY = "oid";
	
	/**
	 * Collects rows of a table filtered by a certain field.
	 * @param columnId
	 * @param value
	 * @throws Exception
	 * @return List
	 */
	@Override
	public List findByColumn(String columnId, String value) throws Exception {
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Order> result = new ArrayList<Order>();
		try {
			c = getConnection();						
			String sql = "SELECT * FROM " + TABLE + " WHERE " + columnId + " = ? ";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, value);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setDesc(rs.getString("desc"));
				order.setPrice(rs.getFloat("price"));
				result.add(order);
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
		List<Order> result = new ArrayList<Order>();
		try {
			c = getConnection();						
			String sql = "SELECT * FROM " + TABLE + " ORDER BY " + fieldToOrder + (!ascendent ? "DESC" : "");
			stmt = c.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setDesc(rs.getString("desc"));
				order.setPrice(rs.getFloat("price"));
				result.add(order);
			}
	        rs.close();
	        stmt.close();
	        //OSIV c.close();
		} catch (Exception e) {
			throw new Exception(e.getClass().getName() + ".findAllOrderBy(): " + e.getMessage());
		}
		return result;
	}
	
	/**
	 * Persists an object as a table record.
	 * @param obj
	 * @throws Exception
	 * @return boolean
	 */
	@Override
	public boolean add(Object obj) throws Exception {
		boolean result = false;
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = getConnection();
			String sql = "insert into" + TABLE + " values (?,?,?)";
			stmt = c.prepareStatement(sql);
			
			Order order = (Order)obj;
			stmt.setInt(1, order.getOid());
			stmt.setString(2, order.getDesc());
			stmt.setFloat(3, order.getPrice());
			
			stmt.executeUpdate();
			stmt.close();
		    c.commit();
			result = true;
	        //OSIV c.close();
		} catch (Exception e) {
			throw new Exception(e.getClass().getName() + ".add(Object obj): " + e.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean exists(Object obj) throws Exception {
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