package com.backupparachute.jig.pattern;

import java.util.regex.Pattern;

public class DoubleCurliesJigPattern implements JigPattern {
	
	private static final String REGEX_KEY_PATTERN = "\\{\\{(.*?)\\}\\}";
	private Pattern pattern;
	
	public DoubleCurliesJigPattern() {
		this.pattern = Pattern.compile(REGEX_KEY_PATTERN);
	}

	@Override
	public Pattern getPattern() {
		return this.pattern;
	}

}
