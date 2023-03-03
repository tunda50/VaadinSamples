package com.vib.vaadin.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.components.CustomComponentOne;
import com.vib.vaadin.view.components.CustomComponentTwo;

@Route("")
public class MyLayout extends VerticalLayout {

    public MyLayout() {
    	CustomComponentOne customComponentOne = new CustomComponentOne();
        CustomComponentTwo customComponentTwo = new CustomComponentTwo();
        add(customComponentOne, customComponentTwo);
    }

}




