package com.vib.vaadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.components.PersonForm;
import com.vib.vaadin.view.components.PersonGrid;

@Route("")
public class MainView extends VerticalLayout {

    private PersonForm personForm = new PersonForm();
    private PersonGrid personGrid = new PersonGrid();

    public MainView() {
        personForm.addClassName("form-component");
        personGrid.addClassName("grid-component");

        Button showButton = new Button("Show Persons", e -> {
            personGrid.updateGrid(personForm.getPersons());
        });

        add(personForm, showButton, personGrid);
    }
}



