package com.backupparachute.jig;

public class StaticJig implements Jig {

	private String template;

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
