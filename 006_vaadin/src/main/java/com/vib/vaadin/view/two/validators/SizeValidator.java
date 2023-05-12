package com.vib.vaadin.view.two.validators;

import java.io.Serializable;

public class SizeValidator extends DataValidator implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int requiredSize;
    public SizeValidator(ValidationCallback callback, int requiredSize){
        super(callback);
        this.requiredSize=requiredSize;
    }
    @Override
    protected boolean isValid(String request) {
        if(request==null){
            return true;
        }
        if (request.length()<requiredSize) {
            return true;
        }
        return false;
    }

    @Override
    protected String errorMessageOnFailure(String request) {
        return "Size id greater than:"+requiredSize;
    }
}