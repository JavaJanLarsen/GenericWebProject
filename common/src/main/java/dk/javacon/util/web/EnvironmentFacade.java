package dk.javacon.util.web;

import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import dk.javacon.util.DependencyHelper;
import dk.javacon.util.PropsHelp;

public class EnvironmentFacade {
	public Properties getProperties() {
		return PropsHelp.get();
	}
	public List<Entry<Object,Object>> getSortedProperties() {
		return PropsHelp.getSorted();
	}
	public List<String> getDependencies(Class<?> clazz) {
		return DependencyHelper.get(clazz);
	}
}
