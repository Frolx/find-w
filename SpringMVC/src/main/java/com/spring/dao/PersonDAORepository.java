package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.test.frlx.Person;

@Repository
public class PersonDAORepository implements PersonDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAORepository.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}
	
	@Override
	public void  updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person"  + p.getName() + " updated");
	}
	
	@Override
	public void addPerson(Person p) { 
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person " + p.getName() + "added");
	}
	
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> pList = session.createQuery("from Person").list();
		 for(Person p : pList){
	            logger.info("Person List::"+p);
	        }
	        return pList;
	}
}
