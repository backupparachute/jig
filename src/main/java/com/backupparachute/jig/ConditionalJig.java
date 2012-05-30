package com.backupparachute.jig;

import com.backupparachute.jig.predicate.JigPredicate;

public class ConditionalJig implements Jig {

	private JigPredicate predicate;
	private Jig positiveJig;
	private Jig negativeJig;
	public void setPositiveJig(Jig jig) {
		this.positiveJig = jig;
	}

	public void setNegativeJig(Jig jig) {
		this.negativeJig = jig;
	}

	public void setPredicate(JigPredicate jigPredicate) {
		this.predicate = jigPredicate;
	}

	@Override
	public String render(Object model) {
		if (predicate.evaluate(model)) return positiveJig.render(model);
		
		return negativeJig.render(model);
	}

}
