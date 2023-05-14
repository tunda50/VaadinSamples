package com.vib.vaadin.view.validators;

import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class FirstNameValidator extends DataValidator<TextField,String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
    public FirstNameValidator(Person p){
        this.person=p;
    }

    @Override
    protected boolean isValid(String request) {
    	System.out.println("First Name validator invocked:"+request);
        if(request==null){
            return true;
        }
        if (!request.equals(person.getPreferedName())) {
           return true;
        }
        return false;
    }

    @Override
    protected String errorMessageOnFailure(String request) {
        return "First Name should not match Prefered Name:"+person.getPreferedName();
    }

}