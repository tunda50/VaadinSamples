package com.vib.vaadin.view.three;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("tabs")
public class TabView extends VerticalLayout {

	public TabView() {
		Tabs tabs = new Tabs();

		Tab tab1 = new Tab("Tab 1");
		VerticalLayout tab1Layout = new VerticalLayout();
		tab1Layout.add(new Label("Content of tab 1"));
		tab1.add(tab1Layout);

		Tab tab2 = new Tab("Tab 2");
		VerticalLayout tab2Layout = new VerticalLayout();
		tab2Layout.add(new Label("Content of tab 2"));
		tab2.add(tab2Layout);

		tabs.add(tab1, tab2);

		add(tabs);
	}
}