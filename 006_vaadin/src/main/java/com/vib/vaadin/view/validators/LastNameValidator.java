package com.vib.vaadin.view.validators;

import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class LastNameValidator extends DataValidator<TextField,String> {

    private Person person;
    public LastNameValidator(Person p){
        this.person=p;
    }

    @Override
    protected boolean isValid(String request) {
    	System.out.println("Last Name validator invocked:"+request);
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
        return "Last Name should not match Prefered name:"+person.getPreferedName();
    }
}