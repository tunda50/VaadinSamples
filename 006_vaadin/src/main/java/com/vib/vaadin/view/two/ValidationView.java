package com.vib.vaadin.view.two;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidationCallback;
import com.vib.vaadin.view.validator.framework.DataValidationResult;
import com.vib.vaadin.view.validator.framework.DataValidator;
import com.vib.vaadin.view.validator.framework.DataValidatorType;
import com.vib.vaadin.view.validator.framework.ValidatableSetter;
import com.vib.vaadin.view.validators.DeceasedValidator;
import com.vib.vaadin.view.validators.FirstNameValidator;
import com.vib.vaadin.view.validators.PeopleDataValidatorFactory;
import com.vib.vaadin.view.validators.SizeValidator;

public class ValidationView extends DetailComponent<Person> {
	
	

	public ValidationView(Person data) {
		super(data);
		init(data);
		binder.readBean(data);
		eventEnabled=true;
	}

	private void init(Person data) {

		DataValidationCallback<TextField> callback = new DataValidationCallback<TextField>() {


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
		
		DataValidationCallback<Checkbox> callbackCheckbox = new DataValidationCallback<Checkbox>() {


			@Override
			public void onFailure(DataValidationResult<Checkbox> result) {
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

		DataValidator<TextField,String> firstNameValidator = PeopleDataValidatorFactory.createValidator(DataValidatorType.FIRST_NAME, callback, data);

		DataValidator<TextField,String> preferedNameValidator = PeopleDataValidatorFactory.createValidator(DataValidatorType.PREFERED_NAME, callback, data);

		DataValidator<TextField,String> lastNameValidator = PeopleDataValidatorFactory.createValidator(DataValidatorType.LAST_NAME, callback, data);
		
		DataValidator<Checkbox,Boolean> deceasedValidator = new DataValidator.ValidatorBuilder<Checkbox,Boolean>().addValidator(new DeceasedValidator(data))
				.addCallback(callbackCheckbox).build();

		
		ValidatableSetter<TextField, Person, String> firstNameSetter= new ValidatableSetter<>(firstNameValidator, Person::setFirstName);
		ValidatableSetter<TextField, Person, String> lastNamesetter= new ValidatableSetter<>(lastNameValidator, Person::setLastName);
		ValidatableSetter<TextField, Person, String> preferedNameSetter= new ValidatableSetter<>(preferedNameValidator, Person::setPreferedName);
		ValidatableSetter<Checkbox, Person, Boolean> deceasedSetter= new ValidatableSetter<>(deceasedValidator, Person::setDeceased);


		TextField firstName = getTextFieldCustom("FirstName", "Enter F", Person::getFirstName, firstNameSetter,
				firstNameValidator);

		TextField lastName = getTextFieldCustom("LastName", "Enter Last", Person::getLastName, lastNamesetter,
				lastNameValidator);

		TextField preferedName = getTextFieldCustom("PreferedName", "Enter Prefered", Person::getPreferedName,
				preferedNameSetter, preferedNameValidator);
		
		
		Checkbox deceasedFlag = getCheckboxCustom("Deceased Flag", Person::isDeceased,
				deceasedSetter, deceasedValidator);
		
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

		add(firstName, lastName, preferedName,deceasedFlag);
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
