package com.vib.vaadin.view.two.validators;

import com.vib.vaadin.view.Person;

public abstract class NameValidator implements MyValidator {
	
	private Person person;
	public NameValidator(Person person) {
		this.person=person;
	}

	@Override
	public boolean isValid(String text) {
       if(text.equals(person.getFirstName())) {
    	   onSuccess("Name  match :"+text+ " For person:"+person.getFirstName());
    	   return true;
       }else {
    	   onError("Error:Name not match :"+text+ " For person:"+person.getFirstName());
    	   return false;
       }
	}

	
}