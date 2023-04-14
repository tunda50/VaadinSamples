package com.vib.vaadin.view.two;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

import java.util.List;

@Route("list-box-multi-selection")
public class ListBoxMultiSelection extends Div {
	
  

    public ListBoxMultiSelection() {
    	DataService.addDummyPerson();
    	 List<Person> items = DataService.getPeople();
        // tag::snippet[]
        MultiSelectListBox<Person> listBox = new MultiSelectListBox<>();
        listBox.setItems(items);
        listBox.select(items.get(0), items.get(3));
        // end::snippet[]
        listBox.setRenderer(new ComponentRenderer<>(person ->
            new Text(person.getFullName()))
        );
        listBox.setHeight("200px");
        add(listBox);
    }

}
