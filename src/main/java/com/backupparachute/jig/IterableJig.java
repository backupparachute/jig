package com.backupparachute.jig;

import java.util.Collection;
import java.util.Iterator;

public class IterableJig implements Jig {

	private Jig jig;
	private String separator = "";
	
	public IterableJig() {
	}
	
	public IterableJig(Jig jig) {
		this.jig = jig;
	}
	
	@Override
	public String render(Object model) {
		
		if (model instanceof Collection) {
			Collection c = (Collection) model;
			StringBuilder sb = new StringBuilder();
			Integer i = 0;
			for (Iterator iter = c.iterator(); iter.hasNext(); i++) {
//			for (Object o : c) {
				Object o = iter.next();
				sb.append(getJig().render(o));
				if (iter.hasNext()) sb.append(getSeparator());
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

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
