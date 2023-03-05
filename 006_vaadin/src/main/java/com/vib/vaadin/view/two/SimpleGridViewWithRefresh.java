package com.vib.vaadin.view.two;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("simple-grid-refresh")
public class SimpleGridViewWithRefresh extends VerticalLayout {

    private Grid<Person> grid = new Grid<>(Person.class,false);
    private List<Person> personList;

    public SimpleGridViewWithRefresh() {
        // Populate the list with 5 Person objects
    	grid.addColumn(Person::getId).setHeader("ID");
    	grid.addColumn(Person::getFirstName).setHeader("F.N");
    	grid.addColumn(Person::getLastName).setHeader("L.N");
    	grid.addColumn(Person::getEmail).setHeader("Email ID");
    	
    	personList= DataService.getPeople();
        
        Button addMore = new Button("Add More");
        addMore.addClickListener(e -> refreshGrid());
       
        grid.setItems(personList);
        add(addMore,grid);
    }

    public void refreshGrid() {
        // Add 2 more Person objects to the list
    	personList.add(new Person(6,"Tom", "Jones", "tom.jones@example.com"));
    	personList.add(new Person(7,"Sarah", "Johnson", "sarah.johnson@example.com"));

        // Set the items of the grid to the updated list of people
        grid.setItems(personList);
    }
    
}
