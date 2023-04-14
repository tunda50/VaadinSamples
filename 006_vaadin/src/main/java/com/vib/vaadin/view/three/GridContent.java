package com.vib.vaadin.view.three;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
//import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("grid-content")
public class GridContent extends Div {

    public GridContent() {
        // tag::snippet1[]
        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
     //   grid.addColumn(createEmployeeRenderer()).setHeader("Employee")
       //         .setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getProfession).setHeader("Profession")
                .setAutoWidth(true);
        grid.addColumn(createStatusComponentRenderer()).setHeader("Status")
                .setAutoWidth(true);
        // end::snippet1[]

        List<Person> people = DataService.getPeople();
        grid.setItems(people);

        add(grid);
    }

//    private static Renderer<Person> createEmployeeRenderer() {
//        return LitRenderer.<Person> of(
//                "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
//                        + "<vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"User avatar\"></vaadin-avatar>"
//                        + "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
//                        + "    <span> ${item.fullName} </span>"
//                        + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
//                        + "      ${item.email}" + "    </span>"
//                        + "  </vaadin-vertical-layout>"
//                        + "</vaadin-horizontal-layout>")
//                .withProperty("pictureUrl", Person::getPictureUrl)
//                .withProperty("fullName", Person::getFullName)
//                .withProperty("email", Person::getEmail);
//    }

    private static final SerializableBiConsumer<Span, Person> statusComponentUpdater = (
            span, person) -> {
        boolean isAvailable = "Available".equals(person.getStatus());
        String theme = String.format("badge %s",
                isAvailable ? "success" : "error");
        span.getElement().setAttribute("theme", theme);
        span.setText(person.getStatus());
    };

    private static ComponentRenderer<Span, Person> createStatusComponentRenderer() {
        return new ComponentRenderer<>(Span::new, statusComponentUpdater);
    }

}
