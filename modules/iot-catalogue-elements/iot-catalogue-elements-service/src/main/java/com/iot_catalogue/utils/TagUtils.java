package com.iot_catalogue.utils;

import java.util.ArrayList;
import java.util.List;

import com.liferay.petra.string.CharPool;

public class TagUtils {
	
	public static String getValidTagName(String tagName) {
		char[] wordCharArray = tagName.toCharArray();
		String validTagName = "";
		
		for (char c : wordCharArray) {
			boolean isCharValid = true;
			String replacementChar = "";
			if(c == CharPool.AMPERSAND) {
				isCharValid = false;
				replacementChar = " and ";
			}else {
				for (char invalidChar : _INVALID_CHARACTERS) {
					if (c == invalidChar) {
						isCharValid = false;
						break;
					}
				}
			}

			if(isCharValid) {
				validTagName = validTagName + c;
			}else {
				validTagName = validTagName + replacementChar;
			}
		}
		return validTagName.toLowerCase();
	}
	
	public static List<String> getValidTagNames(List<String> tagNames){
		if(tagNames != null) {
			List<String> validTagNames = new ArrayList<String>();
			for(String tagName:tagNames) {
				validTagNames.add(getValidTagName(tagName));
			}
			return validTagNames;
		}
		return null;

	}
	
	private static final char[] _INVALID_CHARACTERS = {
			CharPool.AMPERSAND, CharPool.APOSTROPHE, CharPool.AT,
			CharPool.BACK_SLASH, CharPool.CLOSE_BRACKET, CharPool.CLOSE_CURLY_BRACE,
			CharPool.COLON, CharPool.COMMA, CharPool.EQUAL, CharPool.GREATER_THAN,
			CharPool.FORWARD_SLASH, CharPool.LESS_THAN, CharPool.NEW_LINE,
			CharPool.OPEN_BRACKET, CharPool.OPEN_CURLY_BRACE, CharPool.PERCENT,
			CharPool.PIPE, CharPool.PLUS, CharPool.POUND, CharPool.PRIME,
			CharPool.QUESTION, CharPool.QUOTE, CharPool.RETURN, CharPool.SEMICOLON,
			CharPool.SLASH, CharPool.STAR, CharPool.TILDE
		};
	

}
