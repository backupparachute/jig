package com.backupparachute.jig;

import java.util.HashMap;
import java.util.Map;

import com.backupparachute.jig.pattern.DoubleCurlyJigPattern;
import com.backupparachute.jig.pattern.JigPattern;
import com.backupparachute.jig.pattern.PatternCallback;
import com.backupparachute.jig.util.ModelHelper;
import com.backupparachute.jig.util.ObjectModelHelper;

public class CompositeJig implements Jig {
	
	private Map<String, Jig> jigs = new HashMap();
	private JigPattern jigPattern = new DoubleCurlyJigPattern();
	private String template;
	private ModelHelper modelHelper = new ObjectModelHelper();
	
	@Override
	public String render(final Object model) {
		return getJigPattern().apply(getTemplate(), model, new PatternCallback() {
			
			@Override
			public String handle(String key, Object model) {
				Jig jig = (Jig) getJigs().get(key);
				if (null != jig) {
					return jig.render(getModelHelper().findValue(model, key));
				}
				
				return "";
			}
		});
	}
	
	public void addJig(String key, Jig jig) {
		jigs.put(key, jig);
	}
	
	public void setJigs(Map jigs) {
		this.jigs = jigs;
	}
	
	public Map getJigs() {
		return jigs;
	}

	public JigPattern getJigPattern() {
		return jigPattern;
	}

	public void setJigPattern(JigPattern jigPattern) {
		this.jigPattern = jigPattern;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public ModelHelper getModelHelper() {
		return modelHelper;
	}

	public void setModelHelper(ModelHelper modelHelper) {
		this.modelHelper = modelHelper;
	}

}
