package com.revature.data;

import com.revature.data.hibernate.GenreHibernate;
import com.revature.data.hibernate.PersonHibernate;
import com.revature.data.hibernate.RoleHibernate;
import com.revature.data.hibernate.StoryHibernate;
import com.revature.data.hibernate.TypeHibernate;

public class DAOFactory {
	  public static PersonDAO getPersonDAO() {
	    	//return new PersonHibernate();
	    	return new PersonHibernate();
	    }
	  
	  public static StoryDAO getStoryDAO() {
	    	return new StoryHibernate();
	    
	    }
	  
	  public static RoleDAO getRoleDAO() {
	    	return new RoleHibernate();
	    
	    }
	  
	  public static TypeDAO getTypeDAO() {
	    	return new TypeHibernate();
	    
	    }
	  
	  public static GenreDAO getGenreDAO() {
	    	return new GenreHibernate();
	    
	    }

}
