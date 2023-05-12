package com.vib.vaadin.view.two.validators;

import com.vib.vaadin.view.Person;

public class FirstNameValidator extends DataValidator {

    private Person person;
    public FirstNameValidator(ValidationCallback callback, Person p){
        super(callback);
        this.person=p;
    }

    @Override
    protected boolean isValid(String request) {
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