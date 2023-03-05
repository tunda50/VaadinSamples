package com.vib.vaadin.view.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class PersonForm extends VerticalLayout {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");

    private Button saveButton = new Button("Save");

    private Binder<Person> binder = new Binder<>(Person.class);

    private List<Person> persons = new ArrayList<>();

    public PersonForm() {
        binder.bindInstanceFields(this);

        saveButton.addClickListener(e -> {
            Person person = new Person();
            if (binder.writeBeanIfValid(person)) {
                persons.add(person);
                Notification.show("Person saved successfully!");
                binder.readBean(new Person());
            } else {
                Notification.show("Please fill all the required fields!");
            }
        });

        add(firstName, lastName, email, saveButton);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
