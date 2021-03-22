package com.revature.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDaoDB;

public class ShowReimbsController {
	
	static UserDaoDB udao = new UserDaoDB();
	static ReimbsDaoDB rdao = new ReimbsDaoDB();
	
	public static void showReimbs(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		String uname = (String) req.getSession().getAttribute("loggedusername");
		String password = (String) req.getSession().getAttribute("loggedpassword");
		User currentu = udao.getUser(uname, password);
		
		System.out.println("in showreims controller");
		System.out.println(currentu);
		List<Reimbs> allreimbs = rdao.getReimbsByUser(currentu);
		System.out.println(allreimbs);
		res.getWriter().write(new ObjectMapper().writeValueAsString(allreimbs));
	}
}
