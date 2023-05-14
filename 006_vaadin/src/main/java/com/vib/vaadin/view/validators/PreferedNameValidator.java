package com.vib.vaadin.view.validators;

import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class PreferedNameValidator extends DataValidator<TextField,String> {

    private Person person;
    public PreferedNameValidator(Person p){
        this.person=p;
    }

    @Override
    protected boolean isValid(String request) {
    	System.out.println("Prefered Name validator invocked:"+request);
        if(request==null){
            return true;
        }
        if(request.equals(person.getFirstName())){
        	return false;
        }
        if(request.equals(person.getLastName())) {
        	return false;
        }
       
        return true;
    }

    @Override
    protected String errorMessageOnFailure(String request) {
        return "Prefered Name , First Name and Last Name can not be same:"+person.getPreferedName();
    }
}