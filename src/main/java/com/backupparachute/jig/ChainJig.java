package com.backupparachute.jig;

import java.util.ArrayList;
import java.util.List;


public class ChainJig implements Jig {
	
	private List<Jig> jigs = new ArrayList();
	
	@Override
	public String render(final Object model) {
		StringBuilder sb = new StringBuilder();
		
		for (Jig jig : getJigs()) {
			sb.append(jig.render(model));
		}
		
		return sb.toString();
	}
	
	public void addJig(Jig jig) {
		getJigs().add(jig);
	}

	public List<Jig> getJigs() {
		return jigs;
	}

	public void setJigs(List<Jig> jigs) {
		this.jigs = jigs;
	}

	
}
