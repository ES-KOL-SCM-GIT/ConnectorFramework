/**
 * 
 */
package com.rallyrestwsframework.propertyreader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This is propery reader
 * @author Administrator
 *
 */
public final class PropertyReader {
	public static Properties properties = new Properties();
	static{
		String propFileName = "config.properties";
 
		InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
}
