package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.Person;
import com.revature.data.DAOFactory;
import com.revature.data.PersonDAO;
import com.revature.exceptions.NonUniqueUsernameException;

public class PersonServiceImpl implements PersonService{
	
	private PersonDAO personDao;
	//private AuthorDAO authorDao;
	private static Logger log = Logger.getLogger(PersonServiceImpl.class);
	
	public PersonServiceImpl() {
		personDao = DAOFactory.getPersonDAO();
	}

	@Override
	public Integer addPerson(Person p) {
		// TODO Auto-generated method stub
		return personDao.add(p).getId();
	}

	@Override
	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return personDao.getById(id);
	}

	@Override
	public Person getPersonByUsername(String username) {
		// TODO Auto-generated method stub
		return personDao.getByUsername(username);
	}

	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

}
