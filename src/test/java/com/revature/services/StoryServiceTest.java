package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.beans.Story;


class StoryServiceTest {

	public static StoryService storyServ;

		
		@BeforeAll
		public static void setup() {
			storyServ = new StoryServiceImpl();
			
		}
		
		
		@Test
		public void addStoryTest() throws Exception {
			Story s = new Story();
			Integer id = storyServ.addStory(s);
			assertEquals(id, s.getId());
			System.out.println(s);
		}
		

}
