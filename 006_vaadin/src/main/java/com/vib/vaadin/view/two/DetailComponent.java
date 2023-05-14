package com.vib.vaadin.view.two;

import java.io.Serializable;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.ValueProvider;
import com.vib.vaadin.view.validator.framework.DataValidator;

public class DetailComponent<T>  extends VerticalLayout implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Binder<T> binder = new Binder<>();
	protected T data;
	protected boolean eventEnabled;

	public DetailComponent(T data) {
		this.data=data;
		
	}
	
	public TextField getTextFieldCustom(String header, String placeholder, ValueProvider<T,String> getter, Setter<T,String> setter ,DataValidator<TextField,String> validator) {
		TextField nameField = new TextField(header);
		nameField.setMaxLength(50); // Set maximum length for the name field
		nameField.setRequiredIndicatorVisible(true); // Make the field required
		nameField.setValueChangeMode(ValueChangeMode.EAGER);
		nameField.setPlaceholder(placeholder);
		validator.setSource(nameField);
		binder.forField(nameField).withNullRepresentation("").bind(getter, setter);

		
		// Add a value change listener to the name field to handle validation results
		nameField.addValueChangeListener(event -> {
			if(eventEnabled) {
			try {
				binder.writeBean(data);
			} catch (ValidationException e) {
				e.printStackTrace();
			}
			}
		});

		return nameField;
	}

	public Checkbox getCheckboxCustom(String header,ValueProvider<T,Boolean> getter, Setter<T,Boolean> setter ,DataValidator<Checkbox,Boolean> validator) {
		Checkbox checkbox = new Checkbox(header);
		validator.setSource(checkbox);
		binder.forField(checkbox).bind(getter, setter);

		
		// Add a value change listener to the name field to handle validation results
		checkbox.addValueChangeListener(event -> {
			if(eventEnabled) {
			try {
				binder.writeBean(data);
			} catch (ValidationException e) {
				e.printStackTrace();
			}
			}
		});

		return checkbox;
	}
	

//	public TextField getTextField(String header, String placeholder, Validator<String> validator, BindingValidationStatusHandler validationStatusHandler, ValueProvider<T,String> getter, Setter<T,String> setter) {
//		TextField nameField = new TextField(header);
//		nameField.setMaxLength(50); // Set maximum length for the name field
//		nameField.setRequiredIndicatorVisible(true); // Make the field required
//		nameField.setPlaceholder(placeholder);
//
//		binder.forField(nameField)
//				// Define the validator
//				.withValidator(validator)
//				// Define how the validation status is displayed
//				.withValidationStatusHandler(validationStatusHandler)
//				// Finalize the binding
//				.bind(getter, setter);
//
////		// Add a value change listener to the name field to handle validation results
//		nameField.addValueChangeListener(event -> {
//			boolean isValid=binder.isValid();
//			if(isValid) {
//				System.out.println("Set value in Bean");
//			}else {
//				System.out.println("Don't set value in Bean");
//			}
//		});
//
//		return nameField;
//	}
}
