package com.vib.vaadin.view.validators;

import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.validator.framework.DataValidationCallback;
import com.vib.vaadin.view.validator.framework.DataValidator;
import com.vib.vaadin.view.validator.framework.DataValidatorType;

public class PeopleDataValidatorFactory {

	public static DataValidator<TextField,String> createValidator(DataValidatorType type, DataValidationCallback<TextField> callback, Person data) {
		switch (type) {
		case FIRST_NAME:

			return new DataValidator.ValidatorBuilder<TextField, String>().addValidator(new SizeValidator(5))
					.addValidator(new FirstNameValidator(data)).addCallback(callback).build();

		case LAST_NAME:
			return new DataValidator.ValidatorBuilder<TextField, String>().addValidator(new SizeValidator(5))
					.addValidator(new LastNameValidator(data)).addCallback(callback).build();
		case PREFERED_NAME:
			return new DataValidator.ValidatorBuilder<TextField, String>().addValidator(new SizeValidator(5))
					.addValidator(new PreferedNameValidator(data)).addCallback(callback).build();

		}

		return null;

	}

}
