package com.xformation.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class ConfigPropertiesReader {
	
	protected String propFileName = "/com/xformation/resources/config.properties";
 
	private String result;
	private InputStream inputStream;
	
	public String getPropValues(String property) {
		try {
			Properties prop = new Properties();
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property file " + propFileName + " not found in disk");
			}
 
			// get the property value and print it out
			result = prop.getProperty(property);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}