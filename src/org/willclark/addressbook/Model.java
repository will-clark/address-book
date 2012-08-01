package org.willclark.addressbook;

import java.util.ArrayList;
import java.util.List;

public abstract class Model<T> {

	private List<String> validationErrors = new ArrayList<String>(0);
	
	public Model() {}
		
	public boolean isValid() {
		Validator validator = new Validator();
		validator.validate(this);		
		if (validator.hasErrors()) {
			validationErrors = validator.getErrors();
			return false;
		}		
		return true;
	}
	
	public List<String> getValidationErrors() {
		return validationErrors;
	}
	
	public void addValidationError(String error) {
		validationErrors.add(error);
	}
	
	public abstract T parse(Params params);
	
}
