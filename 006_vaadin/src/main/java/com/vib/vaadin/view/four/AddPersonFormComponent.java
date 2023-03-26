package com.vib.vaadin.view.four;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vib.vaadin.view.Person;

public class AddPersonFormComponent extends VerticalLayout{
	
	private OnAddPersonListener onAddPersonListener;
	
	public interface OnAddPersonListener{
		public void onAddPerson(Person p);
	}
	
	public void setOnAddPersonListener(OnAddPersonListener onAddPersonListener) {
		this.onAddPersonListener=onAddPersonListener;
	}
	public AddPersonFormComponent() {
		TextField idField = new TextField("ID");
		TextField firstNameField = new TextField("First Name");
		TextField lastnameField = new TextField("Last Name");
		TextField emailField = new TextField("Email");
		Button saveButton = new Button("Save", event -> {
			Person p = new Person(Integer.parseInt(idField.getValue()), firstNameField.getValue(), lastnameField.getValue(), emailField.getValue());
			onAddPersonListener.onAddPerson(p);
		});
		
		add(idField,firstNameField,lastnameField,emailField ,saveButton);
		
	}
	

}
