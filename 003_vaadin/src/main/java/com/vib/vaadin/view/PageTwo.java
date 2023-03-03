package com.vib.vaadin.view;

import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Route("page-two")
public class PageTwo extends VerticalLayout {
    public PageTwo() {
        Label label = new Label("This is Page Two");
        Button nextButton = new Button("Next");
        nextButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("page-three")));
        Button backButton = new Button("Back");
        backButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("page-one")));
        add(label, nextButton, backButton);
    }
}