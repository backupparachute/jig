package com.backupparachute.jig.util;

import org.apache.commons.beanutils.PropertyUtils;

public class StringModelHelper implements ModelHelper<String>{

	@Override
	public String findValue(Object model, String key) {
		try {
			Object obj = PropertyUtils.getProperty(model, key);
			if (null != obj) return obj.toString();
		} catch (Exception e) {
			// do nothing if no match found
		}
		return "";
	}

}
