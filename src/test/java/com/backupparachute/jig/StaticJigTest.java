package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class StaticJigTest {

	@Test
	public void testOutput() {
		StaticJig jig = new StaticJig("foo bar");
		Map model = new HashMap();
		model.put("name", "asdf");
		
		assertEquals("foo bar", jig.render(model));
	}
	
	@Test
	public void testEmptyModel() {
		StaticJig jig = new StaticJig("foo bar");
		Map model = new HashMap();
		
		assertEquals("foo bar", jig.render(model));
	}
	
	@Test
	public void testNullModel() {
		StaticJig jig = new StaticJig("foo bar");
		
		assertEquals("foo bar", jig.render(null));
	}
}
