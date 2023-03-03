package com.vib.vaadin.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.KeyPressEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
public class MyLayout extends VerticalLayout implements KeyNotifier {

    private TextField textField;
    private Label label;

    public MyLayout() {
        textField = new TextField("Enter text:");
        textField.setPlaceholder("Type something here");
        label = new Label("Hello, world!");
       
        
        //Below works with Enter key
       // viaKeyDownListener();
       // viaValueChangeListener();
       // viaKeyPressListener();
        
        //Without Enter key--Real time
        viaValueChangeListenerWithEager();

       
        
        add(textField, label);
    }

    private void viaValueChangeListenerWithEager() {
    	 textField.setValueChangeMode(ValueChangeMode.EAGER);
         textField.addValueChangeListener(event -> {
             String enteredText = textField.getValue();
             label.setText("You typed: " + enteredText);
         });

        
	}

	private void viaKeyPressListener() {
    	 textField.addKeyPressListener(Key.ENTER, this::onEnterKeyPressed);
	}
    
    private void onEnterKeyPressed(KeyPressEvent event) {
        String enteredText = textField.getValue();
        label.setText("key pressed: " + enteredText);
    }

	private void viaValueChangeListener() {
    	textField.addValueChangeListener(event -> {
            String enteredText = event.getValue();
            label.setText("Value Changed: " + enteredText);
        });		
	}

	private void viaKeyDownListener() {
		//This will require Enter key after finishing typing
		textField.addKeyDownListener(Key.ENTER, this::onEnterKeyDown);		
	}

	  private void onEnterKeyDown(KeyDownEvent event) {
	        String enteredText = textField.getValue();
	        label.setText("You typed: " + enteredText);
	    }

}



