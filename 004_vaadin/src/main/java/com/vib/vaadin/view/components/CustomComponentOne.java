package com.vib.vaadin.view.components;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CustomComponentOne extends VerticalLayout {
    public CustomComponentOne() {
        Label label = new Label("This is Custom Component One");
        add(label);
    }
}