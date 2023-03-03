package com.vib.vaadin.view.components;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CustomComponentTwo extends VerticalLayout {
    public CustomComponentTwo() {
        Label label = new Label("This is Custom Component Two");
        add(label);
    }
}




