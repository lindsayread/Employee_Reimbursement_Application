package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MasterServlet extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in doGet");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in doPost");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req,res);
//		System.out.println("in doPost");
//		String sfd = RequestHelper.process(req,res);
//		req.getRequestDispatcher(sfd).forward(req,res);
//		
//		if(sfd.equals("return.change")) {
//			res.sendRedirect("http://localhost:8080/project1/.html");
//		}
	}
}
