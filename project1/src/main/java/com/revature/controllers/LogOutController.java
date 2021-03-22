package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.utils.SessionCache;

public class LogOutController {
//	public static String logout(Htt)
//	static UserDao udao = new UserDaoDB();
//
//	public static String logout(HttpServletRequest req) {
//		if(!req.getMethod().equals("POST")) {
//			return "resources/html/index.html";
//		}
//		SessionCache.getCurrentUser().invalidate();
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		System.out.println(username);
//		System.out.println(password);
//		
//		User currentu = udao.getUser(username, password);
//		//invalid credentials:
//		if(currentu.getUsername()==null) {
//			return "invalidcredentials.change";
////		if(!(username.equals("cheese")&& password.equals("pizza"))) {
////			return "invalidcredentials.change";
//		}else {
//			SessionCache.setCurrentUser(currentu);
//			//return "userhome.change";
//			req.getSession().setAttribute("loggedusername", username);
//			req.getSession().setAttribute("loggedpassword", password);
//		}
//		return "resources/html/index.html";
//	}
}
