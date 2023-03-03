package com.vib.vaadin.view;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.components.CustomComponentOne;
import com.vib.vaadin.view.components.CustomComponentTwo;

@Route("")
public class MainLayout extends VerticalLayout {

    public MainLayout() {
    	CustomComponentOne customComponentOne = new CustomComponentOne();
        CustomComponentTwo customComponentTwo = new CustomComponentTwo();
        add(customComponentOne, customComponentTwo);
        
        customComponentTwo.addCustomComponentTwoButtonEventListener(e -> {
            Notification.show("Custom Component Two button was clicked!");
            String message=(String) e.getData();
            customComponentOne.updateLable(message);
        });
    }

}




