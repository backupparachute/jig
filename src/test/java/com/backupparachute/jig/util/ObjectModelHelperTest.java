package com.backupparachute.jig.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ObjectModelHelperTest {

	@Test
	public void testModelHelper() {
		ObjectModelHelper helper = new ObjectModelHelper();
		
		Map model = new HashMap();
		model.put("foo", "bar");
		
		assertEquals("bar", helper.findValue(model, "foo"));
		assertEquals(null, helper.findValue(model, "foos"));
		assertEquals(null, helper.findValue(null, "foos"));
		assertEquals(null, helper.findValue(null, null));
		assertEquals(null, helper.findValue(model, null));
	}
}
