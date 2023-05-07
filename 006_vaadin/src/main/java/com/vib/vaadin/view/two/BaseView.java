package com.vib.vaadin.view.two;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vib.vaadin.view.two.BinderExample.Person;
import com.vib.vaadin.view.two.validators.MyValidator;

public class BaseView<T>  extends VerticalLayout {

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
}
