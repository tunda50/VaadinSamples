package com.vib.vaadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MyLayout extends VerticalLayout {

    public MyLayout() {
    	 Label label = new Label("This is main page");
         Button nextButton = new Button("Next");
         nextButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("page-one")));
         add(label, nextButton);
    }

}




