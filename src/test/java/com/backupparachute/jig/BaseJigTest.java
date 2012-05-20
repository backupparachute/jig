package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class BaseJigTest {

	@Test
	public void testRenderTemplateBasic() {
		BaseJig jig = new BaseJig("hello #{foo}");
		
		Map model = new HashMap();
		model.put("foo", "world");
		
		assertEquals("hello world", jig.render(model));
	}
	
}
