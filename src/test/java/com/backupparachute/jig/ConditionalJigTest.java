package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Predicate;
import org.junit.Test;

import com.backupparachute.jig.util.ObjectModelHelper;


public class ConditionalJigTest {

	private ObjectModelHelper modelHelper = new ObjectModelHelper();
	private Predicate predicate = new Predicate() {
		
		@Override
		public boolean evaluate(Object object) {
			Object o = modelHelper.findValue(object, "foo");
			return null != o;
		}
	};
	
	@Test
	public void testOutput() {
		ConditionalJig jig = new ConditionalJig();
		jig.setPredicate(predicate);
		
		StandardJig pos = new StandardJig("positive: {{foo}}");
		StandardJig neg = new StandardJig("negative: {{foo}}");
		
		jig.setNegativeJig(neg);
		jig.setPositiveJig(pos);
		
		Map model = new HashMap();
		model.put("foo", "true");
		
		assertEquals("positive: true", jig.render(model));
	}
	
	@Test
	public void testNegative() {
		ConditionalJig jig = new ConditionalJig();
		jig.setPredicate(predicate);
		
		StandardJig pos = new StandardJig("positive: {{foo}}");
		StandardJig neg = new StandardJig("negative: {{foo}}");
		
		jig.setNegativeJig(neg);
		jig.setPositiveJig(pos);
		
		Map model = new HashMap();
//		model.put("foo", "true");
		
		assertEquals("negative: ", jig.render(model));
	}
	
	@Test
	public void testNullPredicate() {
		ConditionalJig jig = new ConditionalJig();
//		jig.setPredicate(predicate);
		
		StandardJig pos = new StandardJig("positive: {{foo}}");
		StandardJig neg = new StandardJig("negative: {{foo}}");
		
		jig.setNegativeJig(neg);
		jig.setPositiveJig(pos);
		
		Map model = new HashMap();
		model.put("foo", "true");
		
		assertEquals("negative: true", jig.render(model));
	}
}
