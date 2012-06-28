package com.backupparachute.jig;

import org.apache.commons.collections.Predicate;

public class ConditionalJig implements Jig {

	private Predicate predicate;
	private Jig positiveJig;
	private Jig negativeJig;
	public void setPositiveJig(Jig jig) {
		this.positiveJig = jig;
	}

	public void setNegativeJig(Jig jig) {
		this.negativeJig = jig;
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	@Override
	public String render(Object model) {
		if (null != predicate && predicate.evaluate(model)) return positiveJig.render(model);
		
		return negativeJig.render(model);
	}

}
