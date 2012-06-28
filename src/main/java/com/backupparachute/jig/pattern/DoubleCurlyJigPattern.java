package com.backupparachute.jig.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleCurlyJigPattern implements JigPattern {
	
	private static final String REGEX_KEY_PATTERN = "\\{\\{(.*?)\\}\\}";
	private Pattern pattern;
	
	public DoubleCurlyJigPattern() {
		this.pattern = Pattern.compile(REGEX_KEY_PATTERN);
	}

	@Override
	public Pattern getPattern() {
		return this.pattern;
	}
	
	public String apply(String template, Object model, PatternCallback callback) {
		Matcher m = getPattern().matcher(template);

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group(1);
			m.appendReplacement(sb, callback.handle(key, model));
		}

		m.appendTail(sb);
		return sb.toString();
	}
	

}
