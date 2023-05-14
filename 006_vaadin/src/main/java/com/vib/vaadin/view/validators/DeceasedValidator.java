package com.vib.vaadin.view.validators;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class DeceasedValidator extends DataValidator<Checkbox,Boolean> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
    public DeceasedValidator(Person p){
        this.person=p;
    }

    @Override
    protected boolean isValid(Boolean request) {
    	System.out.println("Deceased  validator invocked:"+request);
        if(request==null){
            return true;
        }
        if(request==false) {
        	return true;
        }
        if (person.getPreferedName()==null) {
           return true;
        }
        if (person.getPreferedName().isBlank()) {
            return true;
         }
        return false;
    }

    @Override
    protected String errorMessageOnFailure(Boolean request) {
        return "Prefered Name must be blank for deceased person:"+person.getFirstName();
    }

}