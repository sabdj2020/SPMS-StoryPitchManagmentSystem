package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.beans.StoryGenre;
import com.revature.beans.StoryType;
import com.revature.data.GenreDAO;
import com.revature.utils.HibernateUtil;

public class GenreHibernate implements GenreDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();


	@Override
	public StoryGenre add(StoryGenre t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoryGenre getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<StoryGenre> getAll() {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		String query = "FROM StoryGenre";
		Query<StoryGenre> q = s.createQuery(query, StoryGenre.class);
		List<StoryGenre> sGenreList = q.getResultList();
		Set<StoryGenre> sGenre = new HashSet<>();
		sGenre.addAll(sGenreList);
		s.close();
		return sGenre;
	}

	@Override
	public void update(StoryGenre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StoryGenre t) {
		// TODO Auto-generated method stub
		
	}

}
