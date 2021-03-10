package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.Person;
import com.revature.beans.Story;
import com.revature.data.DAOFactory;
import com.revature.data.PersonDAO;
import com.revature.data.StoryDAO;
import com.revature.exceptions.StoryNoLonguerExistException;

public class StoryServiceImpl implements StoryService {
	private StoryDAO storyDao;
	private PersonDAO personDao;
	
    private static Logger log = Logger.getLogger(StoryServiceImpl.class);
	
	public StoryServiceImpl() {
		storyDao = DAOFactory.getStoryDAO();
		personDao = DAOFactory.getPersonDAO();
	}

	@Override
	public Integer addStory(Story s) {
		// TODO Auto-generated method stub
		try {
			return storyDao.add(s).getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Story getStoryById(Integer id) {
		// TODO Auto-generated method stub
		return storyDao.getById(id);
	}

	@Override
	public Set<Story> getAllStories() {
		// TODO Auto-generated method stub
		return storyDao.getAll();
	}

	@Override
	public Set<Story> getApprouvedStories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStory(Story s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStory(Story s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approuveStory(Story s, Person p) throws StoryNoLonguerExistException {
		// TODO Auto-generated method stub
		storyDao.approuveStory(s, p);
		
	}

	@Override
	public Set<Story> getPersonStories(Person p) {
		// TODO Auto-generated method stub
		return storyDao.getPersonStories(p);
	}

	@Override
	public void rejectStory(Story s, Person p) throws StoryNoLonguerExistException{
		// TODO Auto-generated method stub
		storyDao.rejectStory(s, p);
		
	}

	

}
