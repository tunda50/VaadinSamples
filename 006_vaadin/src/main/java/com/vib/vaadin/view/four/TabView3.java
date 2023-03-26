package com.vib.vaadin.view.four;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("tabs3")
public class TabView3 extends Div {

	private final Tab viewStudents;
	private final Tab addStudent;
	private final VerticalLayout content;

	public TabView3() {
		DataService.clear();
		DataService.addDummyPerson();
		Tabs tabs = new Tabs();

		viewStudents = new Tab("View with Components");
		addStudent = new Tab("Add with Components");
		content = new VerticalLayout();

		content.setSpacing(false);
		add(tabs, content);

		tabs.addSelectedChangeListener(event -> setContent(event.getSelectedTab()));
		tabs.add(viewStudents, addStudent);
	}

	private void setContent(Tab tab) {
		content.removeAll();
		if (tab == null) {
			return;
		}
		if (tab.equals(viewStudents)) {
			content.add(new PersonGridComponent(DataService.getPeople()));
		} else if (tab.equals(addStudent)) {
			AddPersonFormComponent personForm = new AddPersonFormComponent();
			content.add(personForm);
			personForm.setOnAddPersonListener(p -> {
				DataService.addPeople(p);
			});
		}
	}

}