package com.backupparachute.jig;

public class StaticJig implements Jig {

	private String template;
	
	public StaticJig() {
	}
	
	public StaticJig(String template) {
		this.template = template;
	}

	@Override
	public String render(Object model) {
		return getTemplate();
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}

}
