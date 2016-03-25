package org.willclark.addressbook;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.willclark.addressbook.utils.StringUtils;

/*
 * Validator
 *  
 *  
 * Usage: Mark a Class field with an annotation such as @Require
 *        Before saving an object somewhere, such as on an Enter/Edit form,
 *        call the validator as follows:
 *        
 *        Validator validator = new Validator();
 * 		  valitator.validate(object);
 * 
 *        If there are any errors with the object an ArrayList is returned by
 *        validator.getErrors(). It is recommended that you only save the object
 *        if the list is empty.
 * 
 */

public class Validator {

	private Map<String, List<String>> errors = new HashMap<String, List<String>>();
	
	public void validate(Object object) {
		validate(object, null);
	}
	
	public void validate(Object object, String[] bypass) {
		Class<? extends Object> pojoClass = object.getClass();
		Field[] fields = pojoClass.getDeclaredFields();

		for(Field field: fields) {			
			if (skip(pojoClass,field,bypass)) continue;		
			field.setAccessible(true);
			
			Require required = field.getAnnotation(Require.class);
			if (required != null) isSet(object,field,required.name());
			
		}
	}	
	
	public boolean isSet(Object object, Field field, String displayName) {				
		Object value = null;
		
		try {
			value = field.get(object);
		}
		catch (Exception e) {
			// field couldn't be read or was null
		}
		
		if (value == null) {
			if (displayName.equals("")) displayName = StringUtils.toSentenceCase(field.getName());
			setError(displayName, " is required.");
			return false;
		}
		
		return true;
	}
	
	public boolean hasErrors() {
		return (errors.size() > 0);
	}
	
	public List<String> getErrors() {		
		List<String> temp = new ArrayList<String>();
		
		for(String key : errors.keySet()) {
			temp.add(errors.get(key).get(0));
		}
		
		return temp;
	}
	
	private void setError(String key, String message) {
		List<String> messages = errors.get(key);
		
		if (messages == null) {
			messages = new ArrayList<String>(); 
		}

		messages.add(key + " " + message);
		errors.put(key, messages);
	}
		
	@SuppressWarnings("rawtypes")
	private boolean skip(Class objClazz, Field objField, String[] bypass) {
		if (bypass != null) {	
			for(String each : bypass) {
				if (each ==  null) continue;
				
				try {
					Field field = objClazz.getDeclaredField(each);
					if (field.equals(objField)) return true;
				}
				catch (Exception e) {
					// do nothing, field wasn't found or accessible
				}
				
			}
		}		
		return false;
	}
	
}

