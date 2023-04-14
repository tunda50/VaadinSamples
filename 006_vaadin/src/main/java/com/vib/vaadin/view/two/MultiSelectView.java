package com.vib.vaadin.view.two;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.vaadin.componentfactory.multiselect.MultiComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vib.vaadin.dao.DataService;
import com.vib.vaadin.view.Person;

@Route("multiselect")
public class MultiSelectView extends VerticalLayout {

    public MultiSelectView() {
    	 DataService.addDummyPerson();
    	 
    	 sample1();
    	 sample2();
    	
    	
    }
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 10;
    private static final int LIST_LENGTH = 1000;
    
    public static List<String> generateRandomStringList() {
        List<String> randomStringList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < LIST_LENGTH; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < STRING_LENGTH; j++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                sb.append(randomChar);
            }
            String randomString = sb.toString();
            randomStringList.add(randomString);
        }
        
        return randomStringList;
    }
    
   private void sample1(){
	   MultiComboBox<String> combobox = new MultiComboBox<>();
       combobox.setLabel("Persons");
       List<String> personList = generateRandomStringList();
       combobox.setItems(personList);
       add(combobox);
    }
   
   private void sample2(){
	   MultiComboBox<Person> combobox = new MultiComboBox<>();
       combobox.setLabel("Persons");
       List<Person> personList = DataService.getPeople();
       combobox.setItems(personList);
       add(combobox);
    }
    
    
}
