package dk.javacon.util;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DependencyHelper {
	public static List<String> get(Class<?> clazz) {
		List<String> res = new ArrayList<String>();
		Set<ClassLoader> clist = ResourceLoader.getClassLoaders(clazz);
		for (ClassLoader c : clist) {
			res.addAll(getDependencies(c));
		}
		Collections.sort(res);
		return res;
	}

	private static List<String> getDependencies(ClassLoader c) {
		List<String> res = new ArrayList<String>();
		if (c instanceof URLClassLoader) {
			URL[] urls = ((URLClassLoader)c).getURLs();
			for (int i = 0; i < urls.length; i++) {
				res.add(urls[i].toString());
			}
		} else {
			if ("weblogic.utils.classloaders.ChangeAwareClassLoader".equals(c.getClass().getCanonicalName())) {
				try {
					Method m = c.getClass().getMethod("getFinderClassPath");
					String cp = (String) m.invoke(c);
					String[] a = cp.split(";");
					for (int i = 0; i < a.length; i++) {
						String string = a[i];
						res.add(string);
					}
				} catch (Exception e) {
					// too bad
				}
			}
		}
		return res;
	}

}
