package com.vib.vaadin.view;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
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
public class MainView  extends VerticalLayout {

    public MainView() {
         Button simpleGrid = new Button("Simple Grid");
         simpleGrid.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("simple-grid")));
        
         Button simpleGrid2 = new Button("Simple Grid With Custom Headers");
         simpleGrid2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("simple-grid-2")));
        
         
         Button nextButton2 = new Button("Simple Grid With Refresh");
         nextButton2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("simple-grid-refresh")));
        
         Button gridContent = new Button("Grid Content");
         gridContent.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("grid-content")));
        
         Button btnTabs = new Button("Tabs");
         btnTabs.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("tabs")));
        
         Button btnTabs2 = new Button("Tabs2");
         btnTabs2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("tabs2")));
        
         Button btnTabs3 = new Button("Tabs3");
         btnTabs3.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("tabs3")));
        
         add(simpleGrid,simpleGrid2,nextButton2,gridContent,btnTabs,btnTabs2,btnTabs3);
    }

}