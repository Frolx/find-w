package com.spring.service;

import java.util.List;

import com.spring.test.frlx.Person;

public interface PersonService {
	public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
}
