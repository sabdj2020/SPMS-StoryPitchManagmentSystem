package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import com.revature.beans.Person;
import com.revature.beans.Story;
import com.revature.data.StoryDAO;
import com.revature.utils.HibernateUtil;

public class StoryHibernate implements StoryDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Story add(Story st){
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(st);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return st;
	}

	@Override
	public Story getById(Integer id) {
		Session s = hu.getSession();
		Story st = s.get(Story.class, id);
		s.close();
		return st;
	}

	@Override
	public Set<Story> getAll() {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		String query = "FROM Story";
		Query<Story> q = s.createQuery(query, Story.class);
		List<Story> storiesList = q.getResultList();
		Set<Story> stories = new HashSet<>();
		stories.addAll(storiesList);
		s.close();
		return stories;
	}

	@Override
	public void update(Story t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Story t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Story> getPersonStories(Person p) {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		
		  if(p.getRole().getName().contains("Author")) {
			  String hql = "FROM Story WHERE author_id = :authorid ";
			  Query<Story> q = s.createQuery(hql, Story.class);
	          q.setParameter("authorid", p.getId());
	          List<Story> storiesList =q.getResultList();
	  		  Set<Story> stories = new HashSet<>();
	  		  stories.addAll(storiesList);
	  		  s.close();
	  		return stories;
	      
	    	  
	      }else {
	    	  //String hql = "from story where person_id = :pid ";
	  		String query = "FROM Story";
	  		Query<Story> q = s.createQuery(query, Story.class);
	  		List<Story> storiesList = q.getResultList();
	  		Set<Story> stories = new HashSet<>();
	  		stories.addAll(storiesList);
	  		s.close();
	  		return stories;
	      }
	    	  
	}



	@Override
	public void approuveStory(Story st, Person p) {
		// TODO Auto-generated method stub
		
		Session s = hu.getSession();
		
		  if(p.getRole().getName()=="Assitant Editor") {
			  String hql = "UPDATE Story set review1_id = :review1, Story.status.id=5"  + 
	             "WHERE id = :storyid";
	          Query query = s.createQuery(hql);
	          query.setParameter("review1", p.getId());
	          query.setParameter("storyid", st.getId());
	          int result = query.executeUpdate();
		      System.out.println("Rows affected: " + result);
			  s.close();
	      
	      }else if (p.getRole().getName().contains("General Editor")) {
	    	  String hql = "UPDATE Story set review2_id = :review2, Story.status.id=6"  + 
	 	             "WHERE id = :storyid";
	 	          Query query = s.createQuery(hql);
	 	          query.setParameter("review2", p.getId());
	 	          query.setParameter("storyid", st.getId());
	 	          int result = query.executeUpdate();
	 		       System.out.println("Rows affected: " + result);
	 			   s.close();
	    	  
	      }else if (p.getRole().getName().contains("Senior Editor")) {
	    	  String hql = "UPDATE Story set review1_id = :review3, Story.status.id=3"  + 
	 	             "WHERE id = :storyid";
	 	          Query query = s.createQuery(hql);
	 	          query.setParameter("review3", p.getId());
	 	          query.setParameter("storyid", st.getId());
	 	         int result = query.executeUpdate();
	 		     System.out.println("Rows affected: " + result);
	 			  s.close();
	    	  
	      }
	
	}

	@Override
	public void rejectStory(Story st, Person p) {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		
		  if(p.getRole().getName().contains("Assitant Editor")) {
			  String hql = "UPDATE Story set review1_id = :review1, Story.status.id=4 "  + 
	             "WHERE id = :storyid";
	          Query query = s.createQuery(hql);
	          query.setParameter("review1", p.getId());
	          query.setParameter("storyid", st.getId());
	          int result = query.executeUpdate();
		      System.out.println("Rows affected: " + result);
			  s.close();
	      
	      }else if (p.getRole().getName().contains("General Editor")) {
	    	  String hql = "UPDATE Story set review2_id = :review2, Story.status.id=4"  + 
	 	             "WHERE id = :storyid";
	 	          Query query = s.createQuery(hql);
	 	          query.setParameter("review2", p.getId());
	 	          query.setParameter("storyid", st.getId());
	 	          int result = query.executeUpdate();
	 		       System.out.println("Rows affected: " + result);
	 			   s.close();
	    	  
	      }else if (p.getRole().getName().contains("Senior Editor")) {
	    	  String hql = "UPDATE Story set review1_id = :review3, Story.status.id=4"  + 
	 	             "WHERE id = :storyid";
	 	          Query query = s.createQuery(hql);
	 	          query.setParameter("review3", p.getId());
	 	          query.setParameter("storyid", st.getId());
	 	         int result = query.executeUpdate();
	 		     System.out.println("Rows affected: " + result);
	 			  s.close();
	    	  
	      }
		
	}

}
