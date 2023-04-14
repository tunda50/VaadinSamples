package com.vib.vaadin.dao;

import java.util.ArrayList;
import java.util.List;

import com.vib.vaadin.view.Address;
import com.vib.vaadin.view.Person;

public class DataService {
	private static List<Person> list = new ArrayList<>();
	public static List<Person> getPeople(){
		return list;
	}
	
	public static void addDummyPerson() {
		Person p1=new Person(1,"John", "Doe", "john.doe@example.com");
		Person p2=new Person(2,"Jane", "Doe", "jane.doe@example.com");
		Person p3=new Person(3,"Bob", "Smith", "bob.smith@example.com");
		Person p4=new Person(4,"Alice", "Johnson", "alice.johnson@example.com");
		Person p5=new Person(5,"David", "Brown", "david.brown@example.com");
		addAddress(p1);
		addAddress(p2);
		addAddress(p3);
		addAddress(p4);
		addAddress(p5);
		p2.setStatus("Available");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
	}
	
	private static void addAddress(Person p) {
		Address a=new Address();
		a.setCity("Kota");
		a.setPhone("9555505412");
		a.setState("Rajasthan");
		a.setStreet("Keshavpura");
		a.setZip("324009");
		p.setAddress(a);
	}
	
	public static void addPeople(Person p){
		list.add(p);
	}
	
	public static void clear() {
		list.clear();
	}
}

