package com.vib.vaadin.view.two;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.Person;
import com.vib.vaadin.view.two.validators.NameValidator;
import com.vib.vaadin.view.two.validators.NameValidatorVaadin;


@Route("validatorExample")
public class ValidatorExample extends BaseView<Person> {
    
   

    
    public ValidatorExample() {
    	
    	Person p = new Person("vibhor", "bhardwaj", "vibhor.bhardwaj@gmail.com");

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

		add(nameField,nameField2);
    }
    
  
    
   
}