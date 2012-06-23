package com.backupparachute.jig.pattern;

import java.util.regex.Pattern;

public interface JigPattern {
	public Pattern getPattern();
	public String apply(String template, Object model, PatternCallback callback);
}
