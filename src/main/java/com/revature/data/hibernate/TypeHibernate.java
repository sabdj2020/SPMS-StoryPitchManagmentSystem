package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.beans.Story;
import com.revature.beans.StoryType;
import com.revature.data.TypeDAO;
import com.revature.utils.HibernateUtil;

public class TypeHibernate implements TypeDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();


	@Override
	public StoryType add(StoryType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoryType getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<StoryType> getAll() {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		String query = "FROM StoryType";
		Query<StoryType> q = s.createQuery(query, StoryType.class);
		List<StoryType> sTypeList = q.getResultList();
		Set<StoryType> sType = new HashSet<>();
		sType.addAll(sTypeList);
		s.close();
		return sType;
	}

	@Override
	public void update(StoryType t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StoryType t) {
		// TODO Auto-generated method stub
		
	}

}
