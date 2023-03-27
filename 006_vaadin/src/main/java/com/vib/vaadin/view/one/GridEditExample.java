package com.vib.vaadin.view.one;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.grid.editor.EditorSaveEvent;
import com.vaadin.flow.component.grid.editor.EditorSaveListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("grid-edit")
public class GridEditExample extends VerticalLayout {

    private List<MyData> myDataList = new ArrayList<>();
    private Grid<MyData> grid = new Grid<>(MyData.class);

    public GridEditExample() {
        // Initialize the data
        myDataList.add(new MyData(1, "John Doe", "john.doe@example.com"));
        myDataList.add(new MyData(2, "Jane Doe", "jane.doe@example.com"));

        // Set up the grid
        grid.setItems(myDataList);
        grid.addColumn(MyData::getId).setHeader("ID");
        grid.addColumn(MyData::getName).setHeader("Name").setEditorComponent(createTextField());
        grid.addColumn(MyData::getEmail).setHeader("Email").setEditorComponent(createTextField());
        grid.getEditor().addSaveListener(new EditorSaveListener<GridEditExample.MyData>() {

			@Override
			public void onEditorSave(EditorSaveEvent<MyData> event) {
				 // Find the edited item in the list and update it
                for (MyData item : myDataList) {
                    if (event.getItem().equals(item)) {
                        myDataList.set(myDataList.indexOf(item), event.getItem());
                        break;
                    }
                }
                // Save the changes to the database or other storage
                Notification.show("Saved changes");
			}
		});
        
       
        // Add a Save button
        Button saveButton = new Button("Save", e -> saveChanges());

        // Add the components to the layout
        add(grid, saveButton);
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setWidth("100%");
        return textField;
    }

    private void saveChanges() {
        grid.getEditor().save();
    }
    
    public class MyData {
        private int id;
        private String name;
        private String email;
        
        public MyData(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        
        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getEmail() {
            return email;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
    }
}
