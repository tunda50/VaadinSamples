package com.vib.vaadin.view.one;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("simple-grid")
public class SimpleGridView extends VerticalLayout {

    private Grid<Person> grid = new Grid<>(Person.class);

    public SimpleGridView() {
    	List<Person> personList= DataService.getPeople();
        grid.setItems(personList);
        add(grid);
    }

   
    
}
