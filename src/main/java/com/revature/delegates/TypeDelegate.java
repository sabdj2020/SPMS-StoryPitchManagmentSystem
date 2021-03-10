package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.revature.services.TypeService;
import com.revature.services.TypeServiceImpl;

public class TypeDelegate implements FrontControllerDelegate {
	
	private TypeService tServ = new TypeServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = (String) req.getAttribute("path"); // represents the identifier endpoint
		if (path == null || path.equals("")) { //default path ... could get all cats or specific one if you indicate in the code below
			switch (req.getMethod()) {
				
				case "GET":
					resp.getWriter().write(
							om.writeValueAsString(tServ.getAllStoryTypes()));
							//om.writeValueAsString(sServ.getPersonStories(p)));
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}}

	}}
