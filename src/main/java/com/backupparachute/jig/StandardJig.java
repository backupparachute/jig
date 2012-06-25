package com.backupparachute.jig;

import com.backupparachute.jig.pattern.JigPattern;
import com.backupparachute.jig.pattern.ModelPatternCallback;
import com.backupparachute.jig.pattern.WorkerJigPattern;

public class StandardJig implements Jig {

	private String template;
	private JigPattern jigPattern = new WorkerJigPattern();
	public StandardJig() {
	}
	public StandardJig(String template) {
		this.template = template;
	}
	
	@Override
	public String render(final Object model) {
		return getJigPattern().apply(template, model, new ModelPatternCallback());
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public JigPattern getJigPattern() {
		return jigPattern;
	}

	public void setJigPattern(JigPattern jigPattern) {
		this.jigPattern = jigPattern;
	}

}
