package com.vib.vaadin.view.two;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("binderExample")
public class BinderExample extends VerticalLayout {
    
   

    private final TextField textBox1 = new TextField();
    private final Button button1 = new Button("Button1");
    private final Button button2 = new Button("Button2");
   
    
    public BinderExample() {
        // Configure TextBox-1
    	Binder<Person> binder = new Binder<>(Person.class);
        textBox1.setValueChangeMode(ValueChangeMode.EAGER);
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
        });
        
        button2.addClickListener(e ->{
        	person.setName("Vibhor");
        	System.out.println("Main View before read bean:"+person);
        	binder.readBean(person);
//        	try {
//				binder.writeBean(person);
//			} catch (ValidationException e1) {
//				e1.printStackTrace();
//			}
        	System.out.println("Main View after read bean:"+person);
        });
        add(textBox1, button1,button2);
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