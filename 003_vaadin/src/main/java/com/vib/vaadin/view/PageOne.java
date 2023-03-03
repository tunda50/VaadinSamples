package com.vib.vaadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("page-one")
public class PageOne extends VerticalLayout {
    public PageOne() {
        Label label = new Label("This is Page One");
        Button nextButton = new Button("Next");
        nextButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("page-two")));
        add(label, nextButton);
    }
}