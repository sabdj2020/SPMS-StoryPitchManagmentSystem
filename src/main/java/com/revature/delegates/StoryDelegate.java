package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Person;
import com.revature.beans.Story;
import com.revature.exceptions.StoryNoLonguerExistException;
import com.revature.services.StoryService;
import com.revature.services.StoryServiceImpl;

public class StoryDelegate implements FrontControllerDelegate {
	private StoryService sServ = new StoryServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = (String) req.getAttribute("path"); // represents the identifier endpoint
		if (path == null || path.equals("")) { //default path ... could get all cats or specific one if you indicate in the code below
			switch (req.getMethod()) {
				case "POST":
					System.out.println("before calling add");
					// add a cat
					Story s = (Story) om.readValue(req.getInputStream(), Story.class); //create a story based on parameters of request
				try {
					s.setId(sServ.addStory(s));
					System.out.println(s);
					System.out.println("after calling add");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //only thing need cuz new cat has no id
					resp.getWriter().write(om.writeValueAsString(s));
					resp.setStatus(HttpServletResponse.SC_CREATED);
					break;
				case "GET":
					Person p = (Person) req.getSession().getAttribute("person");
					resp.getWriter().write(
							om.writeValueAsString(sServ.getPersonStories(p)));
							//om.writeValueAsString(sServ.getPersonStories(p)));
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}} else if (path.contains("approuve")) {
				if ("POST".equals(req.getMethod())) {
					Story s = (Story) om.readValue(req.getInputStream(), Story.class);
					Person p = (Person) req.getSession().getAttribute("person");
					try {
						sServ.approuveStory(s, p);
					} catch (StoryNoLonguerExistException e) {
						resp.sendError(HttpServletResponse.SC_CONFLICT, "Story no longuer exists");
					}
					resp.getWriter().write(om.writeValueAsString(s));
					resp.setStatus(HttpServletResponse.SC_ACCEPTED);
				} else {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				}
			} else if (path.contains("reject")) {
				if ("POST".equals(req.getMethod())) {
					Story s = (Story) om.readValue(req.getInputStream(), Story.class);
					Person p = (Person) req.getSession().getAttribute("person");
					try {
						sServ.rejectStory(s, p);
					} catch (StoryNoLonguerExistException e) {
						resp.sendError(HttpServletResponse.SC_CONFLICT, "Story no longuer exists");
					}
					resp.getWriter().write(om.writeValueAsString(s));
					resp.setStatus(HttpServletResponse.SC_ACCEPTED);
				} else {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				}
			} else {
				int storyId = Integer.valueOf(path);
				Story s = null;
				switch (req.getMethod()) {
					case "GET":
						s = sServ.getStoryById(storyId);
						if (s != null) 
							resp.getWriter().write(om.writeValueAsString(s));
						else
							resp.sendError(404, "Story not found.");
						break;
					case "PUT":
							s = om.readValue(req.getInputStream(), Story.class);
							sServ.updateStory(s);
							resp.getWriter().write(om.writeValueAsString(s));
	
						break;
					case "DELETE":
							s = om.readValue(req.getInputStream(), Story.class);
							sServ.removeStory(s);
						break;
					default:
						resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
						break;
				}			
			}
		}
		

		
	}


	


