package com.revature.services;

import java.util.Set;

import com.revature.beans.Person;
import com.revature.beans.Story;
import com.revature.exceptions.StoryNoLonguerExistException;

public interface StoryService {
	// Story methods
		public Integer addStory(Story s) throws Exception;
		public Story getStoryById(Integer id);
		public void approuveStory(Story s, Person p) throws StoryNoLonguerExistException;
		public Set<Story> getAllStories();
		public Set<Story> getApprouvedStories();
		public void updateStory(Story s);
		public void removeStory(Story s);
		public Set<Story> getPersonStories(Person p);
		public void rejectStory(Story s, Person p) throws StoryNoLonguerExistException;
}