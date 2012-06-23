package com.backupparachute.jig.pattern;

import com.backupparachute.jig.util.ModelHelper;
import com.backupparachute.jig.util.StringModelHelper;

public class ModelPatternCallback implements PatternCallback {
	
	private ModelHelper<String> modelHelper;
	
	public ModelPatternCallback() {
		this.modelHelper = new StringModelHelper();
	}
	
	public ModelPatternCallback(ModelHelper helper) {
		this.modelHelper = helper;
	}
	
	public String handle(String key, Object model) {
		return modelHelper.findValue(model, key);
	}
}
