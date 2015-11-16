package test;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClass {
	@Getter
	private int i;
	
	public static void main(String[] args) {
		new TestClass().logStuff();
	}

	public String logStuff() {
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		return "Hello";
	}

}
