package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.utils.SessionCache;

public class LoginController {
	
	static UserDao udao = new UserDaoDB();

	public static String login(HttpServletRequest req, HttpServletResponse res) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/index.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		User currentu = udao.getUser(username, password);
		//invalid credentials:
		if(currentu.getUsername()==null) {
			return "invalidcredentials.change";

		}else {
			SessionCache.setCurrentUser(currentu);

			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			
			try {
				res.getWriter().write(new ObjectMapper().writeValueAsString(currentu));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			if (currentu.getUroleid().equals(1)) {
				return "userhome.change";
			} else {
				return "managerhome.change";
			}
			
		}
	}
}
