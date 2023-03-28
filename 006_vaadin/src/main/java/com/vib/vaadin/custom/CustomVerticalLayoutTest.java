package com.vib.vaadin.custom;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("custom-vertical-layout-test")
public class CustomVerticalLayoutTest extends VerticalLayout {

    public CustomVerticalLayoutTest() {
        CustomVerticalLayout v = new CustomVerticalLayout();
        v.add(new Button("Some2"));
        v.add(new Button("Some3"));
        v.setLable("Border details");
        add(v);
    }

   
    
}
