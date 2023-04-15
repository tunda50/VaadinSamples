package com.vib.vaadin.view.two;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.dialog.Dialog.DialogCloseActionEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("binderExample2")
public class BinderExample2 extends VerticalLayout {
    
   

    private final TextField textBox1 = new TextField();
    private final Button button1 = new Button("Open Dialog");
   
    
    public BinderExample2() {
        // Configure TextBox-1
    	Binder<Person> binder = new Binder<>(Person.class);
        textBox1.setValueChangeMode(ValueChangeMode.LAZY);
        binder.bind(textBox1, Person::getName, Person::setName);

        Person person = new Person("John Doe");
        
        // Updates the value in each bound field component
        binder.readBean(person);
        
        // Configure Button-1
        button1.addClickListener(e ->{
        	System.out.println("Main View before write bean:"+person);
        	try {
				binder.writeBean(person);
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
        	System.out.println("Main View after write bean:"+person);
        	openDialog(binder,person);
        });
        
        // Add components to layout
        add(textBox1, button1);
    }
    
    private void openDialog(Binder<Person> binder2, Person person) {
        Dialog dialog = new Dialog();
        TextField textBox2 = new TextField();
        Button button2 = new Button("Save");
        
        textBox2.setValueChangeMode(ValueChangeMode.LAZY);
        binder2.bind(textBox2, Person::getName, Person::setName);
        binder2.readBean(person);
        
        // Configure Button-2
        button2.addClickListener(e -> {
        	 try {
        		 System.out.println("Dialog before write bean:"+person);
				 binder2.writeBean(person);
				 binder2.readBean(person);
				 System.out.println("Dialog after write bean:"+person);
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
            dialog.close();
        });
        
        // Add components to dialog
        dialog.add(new Div(textBox2, button2));
        // Open dialog
        dialog.open();
    }
    
    public static class Person {
        private String name;
        public Person(String name) {
        	this.name=name;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        @Override
        public String toString() {
        	return name;
        }
    }
}