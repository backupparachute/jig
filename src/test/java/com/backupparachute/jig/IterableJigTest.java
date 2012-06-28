package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class IterableJigTest {

	@Test
	public void testOutput() {
		IterableJig iter = new IterableJig(new StandardJig("{{name}}"));
		Map model = new HashMap();
		model.put("name", "foo");
		
		Map model2 = new HashMap();
		model2.put("name", "bar");
		
		List list = new ArrayList();
		list.add(model);
		list.add(model2);
		
		assertEquals("foobar", iter.render(list));
	}
	
	@Test
	public void testSeparator() {
		IterableJig iter = new IterableJig(new StandardJig("{{name}}"));
		iter.setSeparator(", ");
		Map model = new HashMap();
		model.put("name", "foo");
		
		Map model2 = new HashMap();
		model2.put("name", "bar");
		
		List list = new ArrayList();
		list.add(model);
		list.add(model2);
		
		assertEquals("foo, bar", iter.render(list));
	}
	
	@Test
	public void testNonCollection() {
		IterableJig iter = new IterableJig(new StandardJig("{{name}}"));
		iter.setSeparator(", ");
		Map model = new HashMap();
		model.put("name", "foo");
		
		assertEquals("foo", iter.render(model));
	}
	
	@Test
	public void testNull() {
		IterableJig iter = new IterableJig(new StandardJig("{{name}}"));
		
		assertEquals("", iter.render(null));
	}
}
