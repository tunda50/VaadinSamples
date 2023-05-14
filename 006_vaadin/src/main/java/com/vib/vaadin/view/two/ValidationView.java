package com.vib.vaadin.view.two;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidationCallback;
import com.vib.vaadin.view.validator.framework.DataValidationResult;
import com.vib.vaadin.view.validator.framework.DataValidator;
import com.vib.vaadin.view.validator.framework.ValidatableSetter;
import com.vib.vaadin.view.validators.FirstNameValidator;
import com.vib.vaadin.view.validators.LastNameValidator;
import com.vib.vaadin.view.validators.PreferedNameValidator;
import com.vaadin.flow.component.html.Label;

public class ValidationView extends DetailComponent<Person> {
	
	

	public ValidationView(Person data) {
		super(data);
		init(data);
		binder.readBean(data);
		eventEnabled=true;
	}

	private void init(Person data) {

		DataValidationCallback<TextField> callback = new DataValidationCallback<TextField>() {

			private static final long serialVersionUID = 1L;

			@Override
			public void onFailure(DataValidationResult<TextField> result) {
				System.out.println("Show Dialog error message with:" + result.getErrorMessage());
				openDialog(new MyCallback() {
					
					@Override
					public void onOk() {
						if (result.hasSource()) {
							//result.getSource().clear();
							result.getSource().focus();
						}
					}
				}, result.getErrorMessage());
				
			}

		};

		DataValidator<TextField,String> firstNameValidator = new DataValidator.ValidatorBuilder<TextField,String>()
				//.addValidator(new SizeValidator(5))
				.addValidator(new FirstNameValidator(data))
				.addCallback(callback)
				.build();

		DataValidator<TextField,String> preferedNameValidator = new DataValidator.ValidatorBuilder<TextField,String>()
				//.addValidator(new SizeValidator(7))
				.addValidator(new PreferedNameValidator(data))
				.addCallback(callback)
				.build();

		DataValidator<TextField,String> lastNameValidator = new DataValidator.ValidatorBuilder<TextField,String>()
				//.addValidator(new SizeValidator(8))
				.addValidator(new LastNameValidator(data))
				.addCallback(callback)
				.build();
		
		ValidatableSetter<TextField, Person, String> firstNameSetter= new ValidatableSetter<>(firstNameValidator, Person::setFirstName);
		ValidatableSetter<TextField, Person, String> lastNamesetter= new ValidatableSetter<>(lastNameValidator, Person::setLastName);
		ValidatableSetter<TextField, Person, String> preferedNameSetter= new ValidatableSetter<>(preferedNameValidator, Person::setPreferedName);

		TextField firstName = getTextFieldCustom("FirstName", "Enter F", Person::getFirstName, firstNameSetter,
				firstNameValidator);

		TextField lastName = getTextFieldCustom("LastName", "Enter Last", Person::getLastName, lastNamesetter,
				lastNameValidator);

		TextField preferedName = getTextFieldCustom("PreferedName", "Enter Prefered", Person::getPreferedName,
				preferedNameSetter, preferedNameValidator);
		
		
		
//		TextField firstName = getTextFieldCustom("FirstName", "Enter F", Person::getFirstName, Person::setFirstName,
//				firstNameValidator);
//
//		TextField lastName = getTextFieldCustom("LastName", "Enter Last", Person::getLastName, Person::setLastName,
//				lastNameValidator);
//
//		TextField preferedName = getTextFieldCustom("PreferedName", "Enter Prefered", Person::getPreferedName,
//				Person::setPreferedName, preferedNameValidator);
		

//		Validator<String> nameValidatorVaadin = new NameValidatorVaadin(data);

//		TextField nameField2 = getTextField("name2", "Enter name2", nameValidatorVaadin,
//				new BindingValidationStatusHandler() {
//					@Override
//					public void statusChange(BindingValidationStatus<?> status) {
//						if (status.isError()) {
//							System.out.println("Show Error with message" + status.getMessage());
//						} else {
//							System.out.println("Show Success with message" + status.getMessage());
//						}
//
//					}
//				}, Person::getFirstName, Person::setFirstName);

		add(firstName, lastName, preferedName);
	}
	
	
	 public static void openDialog(MyCallback callback,String message) {
	        Dialog dialog = new Dialog();
	        dialog.setWidth("600px");
	        dialog.setCloseOnEsc(false);
	        dialog.setCloseOnOutsideClick(false);

	        Label textField = new Label(message);

	        Button okButton = new Button("OK");
	        VerticalLayout content = new VerticalLayout(textField, new HorizontalLayout(okButton));
	        dialog.add(content);

	        okButton.addClickListener(event -> {
	                callback.onOk();
	            dialog.close();
	        });


	        dialog.open();
	    }

	    public interface MyCallback {
	        void onOk();
	    }

}
