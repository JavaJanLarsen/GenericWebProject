package dk.javacon.util;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoader {
	public static InputStream findResource(Class<?>clazz, String name) {
		InputStream res = null;
		for (ClassLoader c : getClassLoaders(clazz)) {
			res = c.getResourceAsStream(name);
			if (res != null) {
				break;
			}
		}
		return res;
	}
	
	public static InputStream findResource(String name) {
		return findResource(null, name);
	}
	
	public static Set<ClassLoader> getClassLoaders(Class<?> clazz) {
		Set<ClassLoader> res = new HashSet<ClassLoader>();
		res.add(Thread.currentThread().getContextClassLoader());
		if (clazz != null) {
			res.add(clazz.getClassLoader());
		}
		res.add(ResourceLoader.class.getClassLoader());
		for (ClassLoader c : res) {
			log.debug("Found ClassLoader: "+c.getClass().getCanonicalName());
		}
		return res;
	}
}
