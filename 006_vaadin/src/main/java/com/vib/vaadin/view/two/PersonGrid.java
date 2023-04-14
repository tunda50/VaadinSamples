package com.vib.vaadin.view.two;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.function.SerializableFunction;
import com.vaadin.flow.function.SerializableSupplier;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.view.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Route("person-grid")
public class PersonGrid extends VerticalLayout {

    public PersonGrid() {
        // Create some sample data
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(new Name("John", "Doe"), new Address("123 Main St", "Anytown", "CA", "USA")));
        personList.add(new Person(new Name("Jane", "Smith"), new Address("456 Elm St", "Othertown", "NY", "USA")));
        personList.add(new Person(new Name("Bob", "Johnson"), new Address("789 Oak St", "Thirdtown", "TX", "USA")));

        Grid<Person> grid = new Grid<>();
        grid.setItems(personList);
        
		grid.addColumn(person -> person.getName().getFirstName()).setHeader("Name").setKey("name");

		grid.addColumn(person -> person.getAddress().getHouseNumber()).setHeader("Address").setKey("address");

        grid.setItemDetailsRenderer(createRenderer());       
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setDetailsVisibleOnClick(false);
        add(grid);
    }
    
    private Renderer<Person> createRenderer() {
    	SerializableSupplier supplier=new SerializableSupplier<PersonDetailsFormLayout>() {
			@Override
			public PersonDetailsFormLayout get() {
				return new PersonDetailsFormLayout();
			}
		};
    	
		SerializableBiConsumer biconsumer=new SerializableBiConsumer<PersonDetailsFormLayout, Person>() {

			@Override
			public void accept(PersonDetailsFormLayout t, Person u) {
				t.setPerson(u);
			}
		};
    	
		return new ComponentRenderer<>(supplier, biconsumer);
	}

    
    private static class PersonDetailsFormLayout extends FormLayout {
        private final TextField firstName = new TextField("First Name");
        private final TextField lastName = new TextField("Last Name");
        private final TextField houseNum = new TextField("House No");
        private final TextField city = new TextField("City");
        private final TextField state = new TextField("State");
        private final TextField country = new TextField("Country");

        public PersonDetailsFormLayout() {
            Stream.of(firstName, lastName, houseNum, city, state,
            		country).forEach(field -> {
               // field.setReadOnly(true);
                add(field);
            });
          
        }

        public void setPerson(Person person) {
        	firstName.setValue(person.getName().getFirstName());
        	lastName.setValue(person.getName().getLastName());
        	houseNum.setValue(person.getAddress().getHouseNumber());
        	city.setValue(person.getAddress().getCity());
        	state.setValue(person.getAddress().getState());
        	country.setValue(person.getAddress().getCountry());
        }
    }

    
    
	public static class Person {
        private Name name;
        private Address address;
        

        public Person(Name name, Address address) {
            this.name = name;
            this.address = address;
        }

        public Name getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }
        
    }

    public static class Name {
        private String firstName;
        private String lastName;
        
        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
        
    }

    public static class Address {
    	 private String houseNumber;
    	    private String city;
    	    private String state;
    	    private String country;

    	    public Address(String houseNumber, String city, String state, String country) {
    	        this.houseNumber = houseNumber;
    	        this.city = city;
    	        this.state = state;
    	        this.country = country;
    	    }

    	    public String getHouseNumber() {
    	        return houseNumber;
    	    }

    	    public void setHouseNumber(String houseNumber) {
    	        this.houseNumber = houseNumber;
    	    }


    	    public String getCity() {
    	        return city;
    	    }

    	    public void setCity(String city) {
    	        this.city = city;
    	    }

    	    public String getState() {
    	        return state;
    	    }

    	    public void setState(String state) {
    	        this.state = state;
    	    }

    	    public String getCountry() {
    	        return country;
    	    }

    	    public void setCountry(String country) {
    	        this.country = country;
    	    }

    	}
    
    
}