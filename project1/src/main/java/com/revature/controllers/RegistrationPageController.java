package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;

public class RegistrationPageController {
	static UserDao udao = new UserDaoDB();

	public static String registerp(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/register.html";
		}
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String urole = req.getParameter("urole");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(req.getParameter("urole"));

		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPassword(password);
		user.setUsername(username);
		if (urole.equals("employee")) {
			user.setUroleid(1);
		} else {
		user.setUroleid(2);
		}

		List<User> allus= udao.getAllUsers();
		ArrayList unames = new ArrayList();
		for (User u : allus) {
			System.out.println(u);
			System.out.println(u.getUsername());
			unames.add(u.getUsername());
		}
		System.out.println(unames);
		if (unames.contains(user.getUsername())) {
			System.out.println("username already exists");
			return "/resources/html/usernamealreadyexists.html";
		} else {
			udao.addUser(user);
			System.out.println("user added");
			
			return "/resources/html/index.html";
		}
		
	}
}
