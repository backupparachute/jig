package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class JigTest {

	@Test
	public void testSimpleUsage() {
		
		StaticJig jig = new StaticJig();
		jig.setTemplate("foo bar");
		
		assertEquals("foo bar", jig.render(null));
		
	}
	
	@Test
	public void testComplexTemplate() {
 		
		String template = "" +
//				"{{title}}" +
//				"\n" +
				"{{header}}" +
				"\n" +
				"Items:\n" +
//				"\n" +
				"{{items}}" +
				"\n" +
				"Footer:\n" +
				"{{footer}}" +
				"";
		
		String output = "" +
				"Company Foo Receipt\n" +
				"\n" +
				"Header Info\n" +
				"\n" +
				"Items:\n" +
				"\n" +
				"123:item 1\n" +
				"456:item 2\n" +
				"789:item 3\n" +
				"\n" +
				"Footer info:\n" +
				"addr line 1\n" +
				"addr line 2\n" +
				"stl, mo 63124\n" +
				"";
		
		Map model = createModel();
		
		String itemsTemplate = "{{id}}:{{name}}\n";
		
		String footerTemplate = "{{addr_line1}}\n" +
				"{{addr_line2}}\n" +
				"{{city}}, {{state}} {{zip}}\n" +
				"";
		
		StandardJig footerJig = new StandardJig();
		footerJig.setTemplate(footerTemplate);
		
		CompositeJig comp = new CompositeJig();
		comp.setTemplate(template);
		comp.addJig("footer", footerJig);
		StaticJig headerJig = new StaticJig();
		headerJig.setTemplate("Header Info\n");
		comp.addJig("header", headerJig);
		
		IterableJig iter = new IterableJig();
		StandardJig itemJig = new StandardJig();
		itemJig.setTemplate(itemsTemplate);
		iter.setJig(itemJig);
		comp.addJig("items", iter);
		
		System.out.println(comp.render(model));
		
	}

	protected Map createModel() {
		Map model = new HashMap();
		model.put("title", "Company Foo Receipt");
		model.put("header", "Header Info");
		
		
		List items = new ArrayList();
		Map item1 = new HashMap();
		item1.put("id", "123");
		item1.put("name", "item 1");
		items.add(item1);
		
		Map item2 = new HashMap();
		item2.put("id", "456");
		item2.put("name", "item 2");
		items.add(item2);
		
		Map item3 = new HashMap();
		item3.put("id", "789");
		item3.put("name", "item 3");
		items.add(item3);
		
		model.put("items", items);
		
		Map footer = new HashMap();
		footer.put("addr_line1", "addr line 1");
		footer.put("addr_line2", "addr line 2");
		footer.put("city", "stl");
		footer.put("state", "mo");
		footer.put("zip", "63124");
		
		model.put("footer", footer);
		
		return model;
	}
}
