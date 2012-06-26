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
		StandardJig jig = new StandardJig("{{name}}"); 
		IterableJig iter = new IterableJig(jig);
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
		StandardJig jig = new StandardJig("{{name}}"); 
		IterableJig iter = new IterableJig(jig);
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
		StandardJig jig = new StandardJig("{{name}}"); 
		IterableJig iter = new IterableJig(jig);
		iter.setSeparator(", ");
		Map model = new HashMap();
		model.put("name", "foo");
		
		assertEquals("foo", iter.render(model));
	}
	
	@Test
	public void testNull() {
		StandardJig jig = new StandardJig("{{name}}"); 
		IterableJig iter = new IterableJig(jig);
		
		assertEquals("", iter.render(null));
	}
}
