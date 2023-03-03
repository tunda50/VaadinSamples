package com.vib.vaadin.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MyLayout extends VerticalLayout {

    public MyLayout() {
        add(new Label("Hello, world!"));
    }

}




