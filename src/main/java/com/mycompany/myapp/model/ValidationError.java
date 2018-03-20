package com.mycompany.myapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FieldError> fieldErrors = new ArrayList<FieldError>();

    /**
     * 
     */
    public ValidationError() {

    }

    /**
     * @param path
     * @param message
     */
    public void addFieldError(String path, String message) {
        FieldError fieldError = new FieldError(path, message);
        fieldErrors.add(fieldError);
    }

    /**
     * @return
     */
    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
