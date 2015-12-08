package dk.javacon.util.web;

import java.util.Properties;

import dk.javacon.util.PropsHelp;

public class EnvironmentFacade {
	public Properties getProperties() {
		return PropsHelp.get();
	}
}
