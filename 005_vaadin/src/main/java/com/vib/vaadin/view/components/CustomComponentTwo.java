package com.vib.vaadin.view.components;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class CustomComponentTwo extends VerticalLayout {
    public static class CustomComponentTwoButtonEvent extends ComponentEvent<CustomComponentTwo> {
        private Object data;

        public CustomComponentTwoButtonEvent(CustomComponentTwo source, Object data) {
            super(source, false);
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public CustomComponentTwo() {
        Label label = new Label("This is Custom Component Two");
        Button button = new Button("Click me");
        button.addClickListener(e -> fireEvent(new CustomComponentTwoButtonEvent(this, "Some data passed from Component two")));
        add(label, button);
    }

    public Registration addCustomComponentTwoButtonEventListener(ComponentEventListener<CustomComponentTwoButtonEvent> listener) {
        return addListener(CustomComponentTwoButtonEvent.class, listener);
    }
}



