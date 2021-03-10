package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.beans.Person;

class PersonServiceTest {
	public static PersonService personServ;

	
	@BeforeAll
	public static void setup() {
		personServ = new PersonServiceImpl();
		
	}
	
	
	@Test
	public void addPersonTest() throws Exception {
		Person p = new Person();
		Integer id = personServ.addPerson(p);
		assertEquals(id, p.getId());
		System.out.println(p);
	}
	

}
