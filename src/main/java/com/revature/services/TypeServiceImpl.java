package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.StoryType;
import com.revature.data.DAOFactory;
import com.revature.data.TypeDAO;

public class TypeServiceImpl implements TypeService{
	private TypeDAO typeDao;
	
    private static Logger log = Logger.getLogger(StoryServiceImpl.class);
	
	public TypeServiceImpl() {
		typeDao = DAOFactory.getTypeDAO();
	}

	@Override
	public Set<StoryType> getAllStoryTypes() {
		// TODO Auto-generated method stub
		return typeDao.getAll();
	}

}
