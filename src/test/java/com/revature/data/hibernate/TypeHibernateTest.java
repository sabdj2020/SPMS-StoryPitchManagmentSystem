package com.revature.data.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.StoryType;


public class TypeHibernateTest {
	
	public static TypeHibernate typeDao;


	@BeforeEach
	void setUp() throws Exception {
		typeDao = new TypeHibernate();

	}
	
	@Test
	public void getAllStoryTypesTest() {
		Set<StoryType> st = typeDao.getAll();
		for(StoryType t: st) {
			assertEquals(t.getName(),"Novel");
		}	
	}
	

}
