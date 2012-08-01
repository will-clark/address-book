package org.willclark.addressbook.utils;

public class StringUtils {

    public static String toSentenceCase(String text) {
		StringBuilder temp = new StringBuilder();
		temp.append(text.substring(0,1).toUpperCase());
		temp.append(text.substring(1, text.length()));
		return temp.toString();
    }
    
}
