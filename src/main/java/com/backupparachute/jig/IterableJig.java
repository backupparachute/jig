package com.backupparachute.jig;

import java.util.Collection;

public class IterableJig implements Jig {

	private Jig jig;
	@Override
	public String render(Object model) {
		
		if (model instanceof Collection) {
			Collection c = (Collection) model;
			StringBuilder sb = new StringBuilder();
			for (Object o : c) {
				sb.append(getJig().render(o));
			}
			return sb.toString();
		}
		
		return getJig().render(model);
	}
	public Jig getJig() {
		return jig;
	}
	public void setJig(Jig jig) {
		this.jig = jig;
	}

}
