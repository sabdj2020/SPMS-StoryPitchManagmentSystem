package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.StoryGenre;
import com.revature.data.DAOFactory;
import com.revature.data.GenreDAO;

public class GenreServiceImpl implements GenreService {
private GenreDAO genreDao;
	
    private static Logger log = Logger.getLogger(GenreServiceImpl.class);
	
	public GenreServiceImpl() {
		genreDao = DAOFactory.getGenreDAO();
	}


	@Override
	public Set<StoryGenre> getAllStoryGenres() {
		// TODO Auto-generated method stub
		return genreDao.getAll();
	}

}
