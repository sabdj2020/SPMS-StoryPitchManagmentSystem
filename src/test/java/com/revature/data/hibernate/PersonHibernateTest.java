package com.revature.data.hibernate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Person;
import com.revature.services.PersonService;
import com.revature.services.PersonServiceImpl;


class PersonHibernateTest {

public static PersonService pserv;
public static PersonHibernate personDao;

	
	@BeforeAll
	public static void setup() {
		pserv = new PersonServiceImpl();
		personDao = new PersonHibernate();
	}
	
	
	
	@Test
	public void getPersonByUsernameTestdao() {
		Person p = personDao.getByUsername("revature");
		assertEquals("revature", p.getUsername());
		System.out.println(p);
	}
	
	@Test
	public void getPersonByUsernameTest() {
		Person p = pserv.getPersonByUsername("revature");
		assertEquals("revature", p.getUsername());
		System.out.println(p);
	}
	
	@Test
	public void getPersonByIdTest() {
		Person p = personDao.getById(1);
		assertEquals(1, p.getId());
		System.out.println(p);
	}

}
