package com.backupparachute.jig.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class StringModelHelperTest {

	@Test
	public void testModelHelper() {
		StringModelHelper helper = new StringModelHelper();
		
		Map model = new HashMap();
		model.put("foo", "bar");
		
		assertEquals("bar", helper.findValue(model, "foo"));
		assertEquals("", helper.findValue(model, "foos"));
		assertEquals("", helper.findValue(null, "foos"));
		assertEquals("", helper.findValue(null, null));
		assertEquals("", helper.findValue(model, null));
	}
}
