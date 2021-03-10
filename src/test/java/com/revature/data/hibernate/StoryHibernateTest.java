package com.revature.data.hibernate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Person;
import com.revature.beans.Story;

class StoryHibernateTest {
	public static StoryHibernate storyDao;


	@BeforeEach
	void setUp() throws Exception {
		storyDao = new StoryHibernate();

	}

	@Test
	void addStoryTest() throws Exception {
		Story s = new Story();
		Story s1 = storyDao.add(s);
		assertEquals(s1.getTitle(), s.getTitle());
	}
	
	@Test
	void approuveStoryTest() throws Exception {
		Story s = new Story();
		Person p = new Person();
		if(p.getRole().getName().contains("Assistant Editor")) {
		storyDao.approuveStory(s,p);
		assertEquals("Approved1", s.getTitle());
		}else if(p.getRole().getName().contains("General Editor")) {
			storyDao.approuveStory(s,p);
			assertEquals("Approved2", s.getTitle());
		}else if(p.getRole().getName().contains("Senior Editor")) {
			storyDao.approuveStory(s,p);
			assertEquals("Approved", s.getTitle());
			}
	}
	
	@Test
	void rejectStoryTest() throws Exception {
		Story s = new Story();
		Person p = new Person();
		if(p.getRole().getName().contains("Assistant Editor")) {
		storyDao.rejectStory(s,p);
		assertEquals("rejected", s.getTitle());
		}else if(p.getRole().getName().contains("General Editor")) {
			storyDao.rejectStory(s,p);
			assertEquals("rejected", s.getTitle());
		}else if(p.getRole().getName().contains("Senior Editor")) {
			storyDao.rejectStory(s,p);
			assertEquals("rejected", s.getTitle());
			}
	}

}
