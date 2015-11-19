package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClassTest {

	@Test
	public void testLogStuff() {
		assertTrue(new TestClass().logStuff().startsWith("Hello"));
	}

}
