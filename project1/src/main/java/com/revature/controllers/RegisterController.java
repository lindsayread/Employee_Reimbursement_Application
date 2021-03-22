package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

public class RegisterController {
	public static String register(HttpServletRequest req) {
//		if(!req.getMethod().equals("POST")) {
//			return "resources/html/index.html";
//			//return "resources/html/register.html";
//		} else {
//			return "register.change";
//		}
		//return "resources/html/index.html";
		return "register.change";
	}
}
