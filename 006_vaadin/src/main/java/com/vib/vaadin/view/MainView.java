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
        
         Button gridEditBtn = new Button("Grid Edit");
         gridEditBtn.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("grid-edit")));
        
         
         
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
        
         
         Button btnCustomLayout = new Button("CustomVerticalLayoutTest");
         btnCustomLayout.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("custom-vertical-layout-test")));
        
         Button btnWarningMessage = new Button("warning-message");
         btnWarningMessage.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("warning-message")));
        
         Button btnWarningMessage2 = new Button("warning-message2");
         btnWarningMessage2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("warning-message2")));
        
         Button btnWarningMessage3 = new Button("notification-error");
         btnWarningMessage3.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("notification-error")));
        
         Button btnGridDetail = new Button("grid-item-details");
         btnGridDetail.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("grid-item-details")));
        
         Button btnScrollBar = new Button("grid-scrollbar");
         btnScrollBar.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("grid-scrollbar")));
        
         
         Button btnPersonGrid = new Button("person-grid");
         btnPersonGrid.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("person-grid")));
        
         Button listboxmultiselection = new Button("list-box-multi-selection");
         listboxmultiselection.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("list-box-multi-selection")));
        
         Button multiselect = new Button("multiselect");
         multiselect.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("multiselect")));
        
         Button binderExample = new Button("binderExample");
         binderExample.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("binderExample")));
        
         Button binderExample2 = new Button("binderExample2");
         binderExample2.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("binderExample2")));
        
         
         
         
         add(simpleGrid,gridEditBtn,simpleGrid2,nextButton2,gridContent,btnTabs,btnTabs2,btnTabs3
        		 ,btnCustomLayout,btnWarningMessage,
        		 btnWarningMessage2,btnWarningMessage3,btnGridDetail,btnScrollBar,btnPersonGrid,listboxmultiselection,multiselect,binderExample,binderExample2);
    }

}