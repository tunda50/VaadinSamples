package com.vib.vaadin.view.four;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("tabs")
public class TabView  extends Div {

    private final Tab details;
    private final Tab payment;
    private final Tab shipping;
    private final VerticalLayout content;

    public TabView() {
        details = new Tab("Details");
        payment = new Tab("Payment");
        shipping = new Tab("Shipping");

        Tabs tabs = new Tabs();
        tabs.setAutoselect(false);

        tabs.addSelectedChangeListener(
                event -> setContent(event.getSelectedTab()));
        tabs.add(details, payment, shipping);

        content = new VerticalLayout();
        content.setSpacing(false);

        add(tabs, content);
    }

    private void setContent(Tab tab) {
        content.removeAll();
        if (tab == null) {
            return;
        }
        if (tab.equals(details)) {
            content.add(new Paragraph("This is the Details tab"));
        } else if (tab.equals(payment)) {
            content.add(new Paragraph("This is the Payment tab"));
        } else {
            content.add(new Paragraph("This is the Shipping tab"));
        }
    }

}