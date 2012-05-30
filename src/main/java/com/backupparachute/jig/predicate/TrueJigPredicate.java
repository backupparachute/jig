package com.backupparachute.jig.predicate;

public class TrueJigPredicate implements JigPredicate {

	@Override
	public boolean evaluate(Object model) {
		return true;
	}

}
