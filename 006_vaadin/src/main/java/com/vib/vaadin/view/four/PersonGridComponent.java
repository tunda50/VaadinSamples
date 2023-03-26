package com.vib.vaadin.view.four;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vib.vaadin.view.Person;

public class PersonGridComponent extends VerticalLayout {

	public PersonGridComponent(List<Person> personList) {
		Grid<Person> grid = new Grid<>(Person.class, false);
		grid.addColumn(Person::getId).setHeader("ID");
		grid.addColumn(Person::getFirstName).setHeader("F.N");
		grid.addColumn(Person::getLastName).setHeader("L.N");
		grid.addColumn(Person::getEmail).setHeader("Email ID");
		grid.setItems(personList);
		add(grid);
	}
	
}
