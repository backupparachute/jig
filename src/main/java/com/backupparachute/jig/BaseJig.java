package com.backupparachute.jig;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.apache.commons.beanutils.PropertyUtils;

import com.backupparachute.jig.pattern.DoubleCurliesJigPattern;
import com.backupparachute.jig.pattern.JigPattern;

public class BaseJig implements Jig {
	
	private JigPattern jigPattern = new DoubleCurliesJigPattern();
	private String template;
	private Map<String, Jig> jigs = new HashMap();
	
	public BaseJig(String template) {
		this.template = template;
	}

	public String render(Object model) {

		Matcher m = getJigPattern().getPattern().matcher(getTemplate());

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group(1);
			m.appendReplacement(sb, handleKey(key, model));
		}

		m.appendTail(sb);
		return sb.toString();
	}

	protected String handleKey(String key, Object model) {
		Object obj = findProperty(key, model);
		Jig jig = getJigs().get(key);
		if (null != jig) return apply(jig, obj);
		else if (null != obj) return obj.toString();
		return "";
	}
	
	protected Object findProperty(String key, Object model) {
		try {
			return PropertyUtils.getProperty(model, key);
		} catch (Exception e) {
			// do nothing if no match found
		}
		
		return null;
	}
	
	protected String apply(Jig jig, Object model) {
		
		if (model instanceof Collection) {
			Collection c = (Collection) model;
			StringBuilder sb = new StringBuilder();
			for (Object obj : c) {
				sb.append(apply(jig, obj));
			}
			return sb.toString();
		} 
		
		return jig.render(model);
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

	public void register(String key, Jig jig) {
		jigs.put(key, jig);
	}
	
	public Map<String, Jig> getJigs() {
		return this.jigs;
	}
}
