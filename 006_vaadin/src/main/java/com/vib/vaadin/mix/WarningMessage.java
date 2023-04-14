package com.vib.vaadin.mix;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.custom.CustomVerticalLayout;

@Route("warning-message")
public class WarningMessage extends VerticalLayout {

    public WarningMessage() {
    	Notification notification = new Notification();
    	notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

    	Div text = new Div(new Text("Failed to generate report"));

    	Button closeButton = new Button(new Icon("lumo", "cross"));
    	closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
    	closeButton.getElement().setAttribute("aria-label", "Close");
    	closeButton.addClickListener(event -> {
    	    notification.close();
    	});

    	HorizontalLayout layout = new HorizontalLayout(text, closeButton);
    	layout.setAlignItems(Alignment.CENTER);

    	notification.add(layout);
    	notification.open();
    }

   
    
}
