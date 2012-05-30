package com.backupparachute.jig;

import org.junit.Test;

import com.backupparachute.jig.predicate.TrueJigPredicate;


public class ConditionalJigTest {

	@Test
	public void testConditional() {
		ConditionalJig conditional = new ConditionalJig();
		conditional.setPositiveJig(new BaseJig("true"));
		conditional.setNegativeJig(new BaseJig("false"));
		conditional.setPredicate(new TrueJigPredicate());
	}
}
