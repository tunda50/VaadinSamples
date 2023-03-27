package com.vib.vaadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MyLayout extends VerticalLayout {

    public MyLayout() {
        add(new Label("Hello, world!"));
        
        Button b = new Button("Notification");
        b.addClickListener(e->{
        	Notification.show("Button Clicked");
        });
        
        Button b2 = new Button("Notification");
        b2.addClickListener(e->{
        	Notification.show("B2 Clicked");
        });
        
        add(b);
        add(b2);
    }

}




