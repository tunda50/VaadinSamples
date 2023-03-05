package com.vib.vaadin.view.one;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("simple-grid-2")
public class SimpleGridView2 extends VerticalLayout {

    private Grid<Person> grid = new Grid<>(Person.class,false);

    public SimpleGridView2() {
        // Populate the list with 5 Person objects
    	grid.addColumn(Person::getId).setHeader("ID");
    	grid.addColumn(Person::getFirstName).setHeader("F.N");
    	grid.addColumn(Person::getLastName).setHeader("L.N");
    	grid.addColumn(Person::getEmail).setHeader("Email ID");
    	
       
    	List<Person> personList= DataService.getPeople();
        grid.setItems(personList);

        add(grid);
    }

   
    
}
