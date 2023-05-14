package com.vib.vaadin.view.validator.framework;

import com.vaadin.flow.data.binder.Setter;

public class ValidatableSetter<SOURCE,BEAN,FIELDVALUE> implements Setter<BEAN, FIELDVALUE> {
    private DataValidator<SOURCE,FIELDVALUE> dataValidator;
    private Setter<BEAN, FIELDVALUE> setter;
    
	
	public ValidatableSetter(DataValidator<SOURCE,FIELDVALUE> dataValidator, Setter<BEAN, FIELDVALUE> setter) {
		this.dataValidator = dataValidator;
		this.setter = setter;
	}


	@Override
	public void accept(BEAN bean, FIELDVALUE fieldvalue) {
		System.out.println("Validatable setter called:"+fieldvalue);
		if(dataValidator.validate(fieldvalue)) {
			setter.accept(bean, fieldvalue);
		}else {
			System.out.println("Invalid field value:"+fieldvalue);
		}
     		
	}

}
