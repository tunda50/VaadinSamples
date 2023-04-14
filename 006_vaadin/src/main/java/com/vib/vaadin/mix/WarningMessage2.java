package com.vib.vaadin.mix;
import java.util.Collections;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.custom.CustomVerticalLayout;

@Route("warning-message2")
@CssImport("./styles/shared-styles.css")
public class WarningMessage2 extends VerticalLayout {

    public WarningMessage2() {
    	 // Create a warning icon
        Icon warningIcon = new Icon(VaadinIcon.WARNING);

        // Set the size and color of the icon
        warningIcon.setSize("24px");
        warningIcon.setColor("red");

        // Create a button to toggle the visibility of the warnings
        Button warningButton = new Button(warningIcon);
        VerticalLayout warningListLayout = new VerticalLayout();
        warningListLayout.setVisible(false);

        // Create a list of warnings
        List<String> warnings = List.of(
                "You are not admin.",
                "Your session will expire in 5 min.",
                "Your account has been locked."
        );

        // Iterate through the warnings list and create a label for each warning
        for (String warning : warnings) {
            Label warningLabel = new Label(warning);
            warningLabel.addClassName("warning-label");
            warningListLayout.add(warningLabel);
        }

        warningButton.addClickListener(event -> {
            // Show/hide the list of warnings
            warningListLayout.setVisible(!warningListLayout.isVisible());
        });

        // Create a layout to hold the button
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        headerLayout.add(warningButton);
        headerLayout.expand(warningButton);

        // Create the main layout and add the warning layout and header layout
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.add(headerLayout, warningListLayout);
        add(mainLayout);

        // Set the size and margin of the header layout to create a top bar
        headerLayout.setWidthFull();
        headerLayout.setHeight("50px");
        headerLayout.setMargin(true);

        
    }

   
    
}
