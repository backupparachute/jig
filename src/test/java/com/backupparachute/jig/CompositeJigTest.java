package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class CompositeJigTest {

	@Test
	public void testOutput() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		StandardJig hwJig = new StandardJig("hello world, {{name}}");
		CompositeJig comp = new CompositeJig();
		comp.addJig("foo", jig);
		comp.addJig("hello", hwJig);
		comp.setTemplate("{{foo}}\n{{hello}}");
		Map model = new HashMap();
		
		Map fooModel = new HashMap();
		fooModel.put("name", "asdf");
		model.put("foo", fooModel);
		
		Map hwModel = new HashMap();
		hwModel.put("name", "blah");
		model.put("hello", hwModel);
		
		assertEquals("foo asdf bar\nhello world, blah", comp.render(model));
	}
	
	@Test
	public void testNullModel() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		StandardJig hwJig = new StandardJig("hello world, {{name}}");
		CompositeJig comp = new CompositeJig();
		comp.addJig("foo", jig);
		comp.addJig("hello", hwJig);
		comp.setTemplate("{{foo}}\n{{hello}}");
		
		assertEquals("foo  bar\nhello world, ", comp.render(null));
	}
	
	@Test
	public void testMissingJigModel() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		StandardJig hwJig = new StandardJig("hello world, {{name}}");
		CompositeJig comp = new CompositeJig();
		comp.addJig("foo", jig);
		comp.addJig("hello", hwJig);
		comp.setTemplate("{{foo}}\n{{hello}}");
		Map model = new HashMap();
		
		Map fooModel = new HashMap();
		fooModel.put("name", "asdf");
		model.put("foo", fooModel);
		
		assertEquals("foo asdf bar\nhello world, ", comp.render(model));
	}
	
	@Test
	public void testMissingJig() {
		StandardJig jig = new StandardJig("foo {{name}} bar");
		StandardJig hwJig = new StandardJig("hello world, {{name}}");
		CompositeJig comp = new CompositeJig();
		comp.addJig("foo", jig);
//		comp.addJig("hello", hwJig);
		comp.setTemplate("{{foo}}\n{{hello}}");
		Map model = new HashMap();
		
		Map fooModel = new HashMap();
		fooModel.put("name", "asdf");
		model.put("foo", fooModel);
		
		Map hwModel = new HashMap();
		hwModel.put("name", "blah");
		model.put("hello", hwModel);
		
		assertEquals("foo asdf bar\n", comp.render(model));
	}
}
