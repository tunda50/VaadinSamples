package com.vib.vaadin.view.components;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CustomComponentOne extends VerticalLayout {
	Label label ;
    public CustomComponentOne() {
        label = new Label("This is Custom Component One");
        add(label);
    }
    
    public void updateLable(String text) {
    	label.setText(text);
    }
    
    
}