package com.vib.vaadin.view.two;
import ch.qos.logback.core.net.SyslogOutputStream;

import java.io.Serializable;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.two.validators.*;


@Route("validatorExample")
public class ValidatorExample extends BaseView<Person>  implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
   

    
    public ValidatorExample() {
    	
    	Person p = new Person("vibhor", "bhardwaj", "preferedName", "vibhor.bhardwaj@gmail.com");

		ValidationCallback callback = new ValidationCallback() {
			@Override
			public void onFailure(Component source,String errorMessage) {
				((TextField)source).focus();
				((TextField)source).clear();
				System.out.println(errorMessage);
			}
		};

		DataValidator firstNameValidator = new DataValidator.ValidatorBuilder(callback)
				.addHandler(new SizeValidator(callback,5))
				.addHandler(new FirstNameValidator(callback,p))
				.build();

		DataValidator lastNameValidator = new DataValidator.ValidatorBuilder(callback)
				.addHandler(new SizeValidator(callback,5))
				.addHandler(new LastNameValidator(callback,p))
				.build();

		DataValidator preferedNameValidator = new DataValidator.ValidatorBuilder(callback)
				.addHandler(new SizeValidator(callback,5))
				.addHandler(new PreferedNameValidator(callback,p))
				.build();

		TextField firstName = getTextField3("FirstName", "Enter F",firstNameValidator);

		TextField lastName = getTextField3("LastName", "Enter Last",lastNameValidator);

		TextField preferedName = getTextField3("PreferedName", "Enter Prefered",preferedNameValidator);
    	TextField nameField = getTextField("Name", "Enter Name",new NameValidator(p) {
			
			@Override
			public void onSuccess(String text) {
				System.out.println("Show dialog with message"+ text);
			}
			
			@Override
			public void onError(String text) {
				System.out.println("Show Error with message"+ text);
			}
		});

		Validator<String> nameValidatorVaadin = new NameValidatorVaadin(p);

		TextField nameField2 = getTextField2("name2", "Enter name2", nameValidatorVaadin, new BindingValidationStatusHandler() {
			@Override
			public void statusChange(BindingValidationStatus<?> status) {
				if(status.isError()){
					System.out.println("Show Error with message"+ status
							.getMessage());
				}else{
					System.out.println("Show Success with message"+ status
							.getMessage());
				}

			}
		}, Person::getFirstName, Person::setFirstName);
		System.out.println("XYZjjjmnoPPQRSTUVWX");
		add(firstName,lastName,preferedName);
    }
    
  
    
   
}