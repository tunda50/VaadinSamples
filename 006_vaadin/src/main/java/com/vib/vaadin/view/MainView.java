package com.vib.vaadin.view;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private EmailField email = new EmailField("Email");
    private Button saveButton = new Button("Save");
    
    private Grid<Person> personGrid = new Grid<>(Person.class);

    private List<Person> persons = new ArrayList<>();
    private ListDataProvider<Person> personDataProvider = new ListDataProvider<>(persons);
    
    private Binder<Person> binder = new BeanValidationBinder<>(Person.class);

    public MainView() {
        
        binder.bindInstanceFields(this);

        binder.forField(email)
            .withValidator(new EmailValidator("Invalid email address"))
            .bind(Person::getEmail, Person::setEmail);

        saveButton.addClickListener(e -> {
            try {
                Person person = new Person();
                binder.writeBean(person);
                persons.add(person);
                personDataProvider.refreshAll();
                binder.readBean(null);
            } catch (ValidationException ex) {
                ex.printStackTrace();
            }
        });
        
        personGrid.setDataProvider(personDataProvider);
        personGrid.removeColumnByKey("id");
        
        add(firstName, lastName, email, saveButton, personGrid);
    }
}
