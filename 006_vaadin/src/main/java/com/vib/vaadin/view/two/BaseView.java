package com.vib.vaadin.view.two;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.data.validator.RegexpValidator;
import com.vaadin.flow.function.ValueProvider;
import com.vib.vaadin.view.two.BinderExample.Person;
import com.vib.vaadin.view.two.validators.MyValidator;
import com.vib.vaadin.view.two.validators.NameValidatorVaadin;

public class BaseView<T>  extends VerticalLayout {

	Binder<T> binder = new Binder<>();
	public TextField getTextField(String header,String placeholder,MyValidator validator) {
		TextField nameField = new TextField(header);
    	nameField.setMaxLength(50); // Set maximum length for the name field
    	nameField.setRequiredIndicatorVisible(true); // Make the field required
    	nameField.setPlaceholder(placeholder); 
    	
    	
    	// Add a value change listener to the name field to handle validation results
    	nameField.addValueChangeListener(event -> {
    		boolean isValid=validator.isValid(event.getValue());
    		if(isValid) {
    		System.out.println("Set value in Bean");
    		}else {
    			System.out.println("Don't set value in Bean");
    		}
    	});
    	
    	return nameField;
	}

	public TextField getTextField2(String header, String placeholder, Validator<String> validator, BindingValidationStatusHandler validationStatusHandler, ValueProvider<T,String> getter, Setter<T,String> setter) {
		TextField nameField = new TextField(header);
		nameField.setMaxLength(50); // Set maximum length for the name field
		nameField.setRequiredIndicatorVisible(true); // Make the field required
		nameField.setPlaceholder(placeholder);

		binder.forField(nameField)
				// Define the validator
				.withValidator(validator)
				// Define how the validation status is displayed
				.withValidationStatusHandler(validationStatusHandler)
				// Finalize the binding
				.bind(getter, setter);

//		// Add a value change listener to the name field to handle validation results
		nameField.addValueChangeListener(event -> {
			boolean isValid=binder.isValid();
			if(isValid) {
				System.out.println("Set value in Bean");
			}else {
				System.out.println("Don't set value in Bean");
			}
		});

		return nameField;
	}
}
