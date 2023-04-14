package com.vib.vaadin.view.two;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("grid-scrollbar")
public class SimpleGridWithScrolBar extends VerticalLayout {

    public SimpleGridWithScrolBar() {
    	setSizeFull();
        setPadding(false);
        setSpacing(false);

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        add(button1, button2, button3, button4);

        Grid<String> grid = new Grid<>();
        grid.setItems(generateData(15));

        grid.addColumn(item -> item).setHeader("Item");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(event -> {
            String selected = event.getFirstSelectedItem().orElse(null);
            System.out.println("Selected item: " + selected);
        });

        add(grid);
    }

    private List<String> generateData(int count) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add("Item " + i);
        }
        return items;
    }

}
