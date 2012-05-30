package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class BaseJigTest {

	@Test
	public void testRenderTemplateBasic() {
		BaseJig jig = new BaseJig("hello {{foo}}");
		
		Map model = new HashMap();
		
		assertEquals("hello ", jig.render(model));
		
		model.put("foo", "world");
		assertEquals("hello world", jig.render(model));
	}
	
	@Test
	public void testRenderTemplateReservedChars() {
		BaseJig jig = new BaseJig("public void main () {\n" +
								  "  //do stuff\n" +
								  "  {{foo}}\n" +
								  "}");
		
		Map model = new HashMap();
		
		model.put("foo", "hello world!");
		assertEquals("public void main () {\n" +
				  "  //do stuff\n" +
				  "  hello world!\n" +
				  "}", jig.render(model));
	}
	
	@Test
	public void testRenderNestedJigs() {
		BaseJig jig = new BaseJig("{{jig1}}\n" +
									"{{jig1}}\n" +
									"{{jig2}}\n");
		jig.register("jig1", new BaseJig("jig 1"));
		jig.register("jig2", new BaseJig("jig 2"));
		
		Map model = new HashMap();
		
		model.put("foo", "hello world!");
		assertEquals("jig 1\n" +
				  "jig 1\n" +
				  "jig 2\n",
				   jig.render(model));
	}
	
	@Test
	public void testRenderNestedStaticJigs() {
		BaseJig jig = new BaseJig("{{header}}\n" +
									"body\n" +
									"{{footer}}\n");
		jig.register("header", new BaseJig("header start"));
		jig.register("footer", new BaseJig("footer:the end"));
		
		assertEquals("header start\n" +
				  "body\n" +
				  "footer:the end\n",
				   jig.render(null));
	}
	
	
	@Test
	public void testRenderNestJigsWithCollection() {
		BaseJig jig = new BaseJig("{{jig1}}\n" +
									"{{jig1}}\n" +
									"{{jig2}}\n");
		jig.register("jig1", new BaseJig("jig 1"));
		jig.register("jig2", new BaseJig("jig 2"));
		
		Map model = new HashMap();
		
		model.put("foo", "hello world!");
		assertEquals("jig 1\n" +
				  "jig 1\n" +
				  "jig 2\n",
				   jig.render(model));
	}
	
	
	@Test
	public void testRenderEmptyJig() {
		BaseJig jig = new BaseJig("foobar");
		
		assertEquals("foobar", jig.render(null));
	}
	
}
