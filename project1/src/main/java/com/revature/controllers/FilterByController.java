package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbsDao;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;

public class FilterByController {
	static UserDao udao = new UserDaoDB();
	static ReimbsDao rdao = new ReimbsDaoDB();
	
	public static String filterby(HttpServletRequest req, HttpServletResponse res) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/managerhome.html";
		}
		System.out.println("in change status");
		
		String statusr = req.getParameter("filterby");
		System.out.println(statusr);
		
		req.getSession().setAttribute("statusRei", statusr);

		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(statusr));
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return "filteredhome.change";

	}
}
