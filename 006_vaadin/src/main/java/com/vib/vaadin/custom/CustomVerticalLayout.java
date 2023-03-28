package com.vib.vaadin.custom;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CustomVerticalLayout extends VerticalLayout {

	 Label label;
    public CustomVerticalLayout() {
        setMargin(false);
        setSpacing(false);
        setWidthFull();

        label = new Label("");
        label.getStyle().set("padding", "0 10px");
        label.getStyle().set("background-color", "white");
        label.getStyle().set("position", "absolute");
        label.getStyle().set("top", "-0.5px");
        //label.getStyle().set("left", "10px");
        label.getStyle().set("font-size", "small");
        label.getStyle().set("font-weight", "bold");

        add(label);

        getStyle().set("border", "1px solid black");
        getStyle().set("padding", "10px");
    }

    public void setLable(String lableText) {
    	label.setText(lableText);
    }
}
