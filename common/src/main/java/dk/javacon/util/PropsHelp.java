package dk.javacon.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropsHelp {
	public static final String DEFAULT_FILE_NAME = "default.properties";
	public static final String ENV_FILE_NAME = "env.properties";	
	private static Properties properties;
	
	/**
	 * @param key The name of a property
	 * @return The property with the name <key> or null if no such property is found
	 */
	public static String get(String key) {
		return get().getProperty(key);
	}
	
	/**
	 * @param key The name of a property
	 * @param defaultValue
	 * @return The property with the name <key> or <defaultValue> if no such property is found
	 */
	public static String get(String key, String defaultValue) {
		return (String)get().getOrDefault(key, defaultValue);
	}
	
	/**
	 * @return A Properties Map containing default properties overwritten by environment properties
	 * overwritten by system properties
	 */
	@Synchronized
	public static Properties get() {
		if (properties == null) {
			properties = new Properties();
			try {
				InputStream is = ResourceLoader.findResource(DEFAULT_FILE_NAME);
				if (is != null) {
					properties.load(is);
					is.close();
				}
				is = ResourceLoader.findResource(ENV_FILE_NAME);				
				if (is != null) {
					properties.load(is);
					is.close();
				}
			} catch (IOException e) {
				log.error("Failed to load properties", e);
			}
			properties.putAll(System.getProperties());
		}
		return properties;
	}
	
	public static List<Entry<Object, Object>> getSorted() {
		List<Entry<Object, Object>> res = new ArrayList<Entry<Object, Object>>();
		
		for (Entry<Object, Object> entry : get().entrySet()) {
			res.add(entry);
		}
		Collections.sort(res, new Comparator<Entry<Object, Object>>() {

			@Override
			public int compare(Entry<Object, Object> o1, Entry<Object, Object> o2) {
				return o1.getKey().toString().compareTo(o2.getKey().toString());
			}
		});
		return res ;
	}
	
}
