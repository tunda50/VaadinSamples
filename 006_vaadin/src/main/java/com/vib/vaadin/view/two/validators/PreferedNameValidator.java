package com.vib.vaadin.view.two.validators;

import com.vib.vaadin.view.Person;

public class PreferedNameValidator extends DataValidator {

    private Person person;
    public PreferedNameValidator(ValidationCallback callback, Person p){
        super(callback);
        this.person=p;
    }

    @Override
    protected boolean isValid(String request) {
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