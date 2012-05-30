package com.backupparachute.jig;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;


public class ChainJigTest {

	@Test
	public void testChaining() {
		ChainJig chain = new ChainJig();
		chain.addJig(new BaseJig("jig 1"));
		chain.addJig(new BaseJig(",jig 2"));
		chain.addJig(new BaseJig(",jig 3"));
		
		assertEquals("jig 1,jig 2,jig 3", chain.render(new HashMap()));
	}
}
