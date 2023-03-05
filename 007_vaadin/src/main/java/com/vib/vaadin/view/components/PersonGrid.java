package com.vib.vaadin.view.components;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;

public class PersonGrid extends VerticalLayout {
    private Grid<Person> grid;
    private ListDataProvider<Person> dataProvider;

    public PersonGrid(List<Person> persons) {
        this.grid = new Grid<>(Person.class);
        this.dataProvider = new ListDataProvider<>(persons);
        this.grid.setDataProvider(dataProvider);
        this.grid.setColumns("firstName", "lastName", "email");
        this.add(grid);
    }

    public void upgradeGrid(Person person, List<Person> persons) {
        dataProvider.getItems().add(person);
        dataProvider.refreshAll();
    }
}
