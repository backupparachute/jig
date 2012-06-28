package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class StandardJigTest {

	@Test
	public void testOutput() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		Map model = new HashMap();
		model.put("name", "asdf");
		
		assertEquals("foo asdf bar", jig.render(model));
	}
	
	@Test
	public void testEmptyModel() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		Map model = new HashMap();
		
		assertEquals("foo  bar", jig.render(model));
	}
	
	@Test
	public void testNoPattern() {
		StandardJig jig = new StandardJig("foo bar");
		Map model = new HashMap();
		model.put("name", "asdf");
		
		assertEquals("foo bar", jig.render(model));
	}
	
	@Test
	public void testCollection() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		Map model = new HashMap();
		List list = new ArrayList();
		list.add("asdf");
		list.add("argh");
		model.put("name", list);
		
		assertEquals("foo [asdf, argh] bar", jig.render(model));
	}
}
