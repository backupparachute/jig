package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ChainJigTest {

	@Test
	public void testOutput() {
		ChainJig jig = new ChainJig();
		StandardJig j1 = new StandardJig("one");
		StandardJig j2 = new StandardJig("{{name}}");
		StandardJig j3 = new StandardJig("three");
		jig.addJig(j1);
		jig.addJig(j2);
		jig.addJig(j3);
		
		Map model = new HashMap();
		model.put("name", "asdf");
		
		assertEquals("oneasdfthree", jig.render(model));
	}
	
	@Test
	public void testNullModel() {
		ChainJig jig = new ChainJig();
		StandardJig j1 = new StandardJig("one");
		StandardJig j2 = new StandardJig("{{name}}");
		StandardJig j3 = new StandardJig("three");
		jig.addJig(j1);
		jig.addJig(j2);
		jig.addJig(j3);
		
		assertEquals("onethree", jig.render(null));
	}
}
