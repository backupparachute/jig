package com.backupparachute.jig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;

public class BaseJig {
	
	private static final String REGEX_KEY_PATTERN = "\\#\\{(.*?)\\}";
	private Pattern pattern;
	private String template;
	
	public BaseJig(String template) {
		this.pattern = Pattern.compile(REGEX_KEY_PATTERN);
		this.template = template;
	}

	public String render(Object model) {

		Matcher m = getPattern().matcher(getTemplate());

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group(1);
			m.appendReplacement(sb, findProperty(key, model));
		}

		m.appendTail(sb);
		return sb.toString();
	}

	
	protected String findProperty(String key, Object model) {
		try {
			Object obj = PropertyUtils.getProperty(model, key);
			if (null != obj) return obj.toString();
		} catch (Exception e) {
			// do nothing if no match found
		}
		
		return "";
	}

	public Pattern getPattern() {
		return pattern;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
