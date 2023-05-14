package com.vib.vaadin.view.validators;

import java.io.Serializable;

import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class SizeValidator extends DataValidator<TextField,String> implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int requiredSize;
    public SizeValidator(int requiredSize){
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