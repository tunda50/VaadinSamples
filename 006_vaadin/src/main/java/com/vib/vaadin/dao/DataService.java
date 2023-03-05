package com.vib.vaadin.dao;

import java.util.ArrayList;
import java.util.List;

import com.vib.vaadin.view.Person;

public class DataService {
	public static List<Person> getPeople(){
		List<Person> list = new ArrayList<>();
		
        Person p1=new Person(1,"John", "Doe", "john.doe@example.com");
		Person p2=new Person(2,"Jane", "Doe", "jane.doe@example.com");
		Person p3=new Person(3,"Bob", "Smith", "bob.smith@example.com");
		Person p4=new Person(4,"Alice", "Johnson", "alice.johnson@example.com");
		Person p5=new Person(5,"David", "Brown", "david.brown@example.com");
         
		p2.setStatus("Available");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		return list;
	}
}

