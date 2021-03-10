package com.revature.data;

import java.util.Set;

import com.revature.beans.Person;
import com.revature.beans.Story;

public interface StoryDAO extends GenericDAO<Story> {
	
	Set<Story> getPersonStories(Person p);
	public void approuveStory(Story s, Person p);
	public void  rejectStory(Story s, Person p);

}
