package com.backupparachute.jig.util;

import org.apache.commons.beanutils.PropertyUtils;

public class ObjectModelHelper implements ModelHelper {

	@Override
	public Object findValue(Object model, String key) {
		try {
			Object obj = PropertyUtils.getProperty(model, key);
			if (null != obj) return obj;
		} catch (Exception e) {
			// do nothing if no match found
		}
		return null;
	}

}
