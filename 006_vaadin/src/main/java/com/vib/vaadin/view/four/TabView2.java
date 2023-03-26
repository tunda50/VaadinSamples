package com.vib.vaadin.view.four;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("tabs2")
public class TabView2 extends Div {

	private final Tab viewStudents;
	private final Tab addStudent;
	private final VerticalLayout content;
    private List<Person> list;
	

	public TabView2() {
		DataService.addDummyPerson();
		Tabs tabs = new Tabs();

		viewStudents = new Tab("View");
		addStudent = new Tab("Add");
		content = new VerticalLayout();
		
		content.setSpacing(false);
		add(tabs, content);
		
		tabs.addSelectedChangeListener(event -> setContent(event.getSelectedTab()));
		tabs.add(viewStudents, addStudent);
		

	}

	private Component gridComponent(List<Person> personList) {
		Grid<Person> grid = new Grid<>(Person.class, false);
		grid.addColumn(Person::getId).setHeader("ID");
		grid.addColumn(Person::getFirstName).setHeader("F.N");
		grid.addColumn(Person::getLastName).setHeader("L.N");
		grid.addColumn(Person::getEmail).setHeader("Email ID");
		grid.setItems(personList);
		return grid;
	}
	
	
	private Component formComponent() {
		TextField idField = new TextField("ID");
		TextField firstNameField = new TextField("First Name");
		TextField lastnameField = new TextField("Last Name");
		TextField emailField = new TextField("Email");
		Button saveButton = new Button("Save", event -> {
			Person p = new Person(Integer.parseInt(idField.getValue()), firstNameField.getValue(), lastnameField.getValue(), emailField.getValue());
			DataService.addPeople(p);
		});
		VerticalLayout formLayout = new VerticalLayout( idField,firstNameField,lastnameField,emailField ,saveButton);
		return formLayout;
	}
	

	

	 private void setContent(Tab tab) {
	        content.removeAll();
	        if (tab == null) {
	            return;
	        }
	        if (tab.equals(viewStudents)) {
	            content.add(gridComponent(DataService.getPeople()));
	        } else if (tab.equals(addStudent)) {
	            content.add(formComponent());
	        }
	    }

	
}