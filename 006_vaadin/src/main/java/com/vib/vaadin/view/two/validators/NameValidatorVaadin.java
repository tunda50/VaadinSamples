package com.vib.vaadin.view.two.validators;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import com.vib.vaadin.view.Person;

public class NameValidatorVaadin implements Validator<String> {
    private Person person;

    public NameValidatorVaadin(Person person) {
        super();
        this.person = person;
    }

    @Override
    public ValidationResult apply(String text, ValueContext context) {

        if (isValid(text)) {
            return ValidationResult.ok();
        } else {
            return ValidationResult.error("Error:Current Name:" + text + "Is not matching with:" + person.getFirstName());
        }
    }

    protected boolean isValid(String value) {
        if (value == null) {
            return true;
        }
        if (value.equals(person.getFirstName())) {
            return true;
        } else {
            return false;
        }
    }

}
