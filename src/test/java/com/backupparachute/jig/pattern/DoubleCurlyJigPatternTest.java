package com.backupparachute.jig.pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class DoubleCurlyJigPatternTest {
	
	@Test
	public void testPattern() {
		DoubleCurlyJigPattern pattern = new DoubleCurlyJigPattern();
		
		Map model = new HashMap();
		String s = pattern.apply("test {{foo}}", model, new PatternCallback() {
			
			@Override
			public String handle(String key, Object model) {
				return "bar";
			}
		});
		
		assertEquals("test bar", s);
	}
	@Test
	public void testBadTemplate() {
		DoubleCurlyJigPattern pattern = new DoubleCurlyJigPattern();
		
		Map model = new HashMap();
		pattern.apply("{foo}} this shouldn't {{another\\}asdf} get called", model, new PatternCallback() {
			
			@Override
			public String handle(String key, Object model) {
				fail("should not have found a pattern");
				return "";
			}
		});
	}

}
