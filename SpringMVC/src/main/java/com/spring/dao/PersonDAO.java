package com.spring.dao;

import java.util.List;

import com.spring.test.frlx.Person;

public interface PersonDAO {
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
}
