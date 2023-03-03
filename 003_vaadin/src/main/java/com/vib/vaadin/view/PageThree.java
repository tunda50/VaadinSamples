package com.vib.vaadin.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("page-three")
public class PageThree extends VerticalLayout {
    public PageThree() {
        Label label = new Label("This is Page Three");
        Button backButton = new Button("Back");
        backButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("page-two")));
        add(label, backButton);
    }
}