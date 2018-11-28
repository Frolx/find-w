package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonDAO;
import com.spring.test.frlx.Person;
@Service
public class PersonServiceImpl implements PersonService {
	    private PersonDAO personDAO;
	 
	    public void setPersonDAO(PersonDAO personDAO) {
	        this.personDAO = personDAO;
	    }
	 
	    @Override
	    @Transactional
	    public void addPerson(Person p) {
	        this.personDAO.addPerson(p);
	    }
	 
	    @Override
	    @Transactional
	    public void updatePerson(Person p) {
	        this.personDAO.updatePerson(p);
	    }
	 
	    @Override
	    @Transactional
	    public List<Person> listPersons() {
	        return this.personDAO.listPersons();
	    }
}
