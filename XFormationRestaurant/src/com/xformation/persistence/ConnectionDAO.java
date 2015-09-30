package com.xformation.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.apache.log4j.Logger;
import com.xformation.resources.ConfigPropertiesReader;

@SuppressWarnings("rawtypes")
public abstract class ConnectionDAO {

	private static ConfigPropertiesReader props = new ConfigPropertiesReader();
	private static final String DB_PATH = props.getPropValues("DB_PATH");
	
	private static Connection c = null;
	
	/**
	 * Provides a connection against the database.
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		//Survival management of the connection here. Connections pool in real life
	    if(c == null) {
		    try {
		    	Class.forName("org.sqlite.JDBC");
		    	c = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
		    	Logger.getLogger(ConnectionDAO.class).debug(c.toString());
		    	c.setAutoCommit(false);
		    } catch ( Exception e ) {
		    	throw new Exception(e.getClass().getName() + ".getConnection(): " + e.getMessage());
		    }
	    }
	    return c;
	  }
	public void closeConnection() throws Exception {
		c.close();
		c = null;
	}

	public abstract List findByColumn(String columnId, String value) throws Exception;
	public abstract List findAll() throws Exception;
	public abstract List findAllOrderBy(String fieldToOrder, boolean ascendent) throws Exception;
	public abstract boolean exists(Object obj) throws Exception;
	public abstract boolean add(Object obj) throws Exception;
	public abstract boolean update(Object obj) throws Exception;
	public abstract int findCount(String table) throws Exception;
	public abstract boolean remove(Object obj) throws Exception;
	public abstract boolean removeByColumn(String columnId, String value) throws Exception;
	public abstract boolean removeAll(String table) throws Exception;

}