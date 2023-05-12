package com.vib.vaadin.view.two.validators;

import com.vib.vaadin.view.Person;

public class LastNameValidator extends DataValidator {

    private Person person;
    public LastNameValidator(ValidationCallback callback, Person p){
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
        return "Last Name should not match Prefered name:"+person.getPreferedName();
    }
}