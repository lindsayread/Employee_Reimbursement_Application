package com.revature.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDaoDB;

public class FilterReimbsJSON {
	static UserDaoDB udao = new UserDaoDB();
	static ReimbsDaoDB rdao = new ReimbsDaoDB();
	
	public static void filterReimbs(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		String uname = (String) req.getSession().getAttribute("loggedusername");
		String password = (String) req.getSession().getAttribute("loggedpassword");
		User currentu = udao.getUser(uname, password);
		String statusr = (String) req.getSession().getAttribute("statusRei");
		
		System.out.println("in showreims controller");
		System.out.println(currentu);
		
		List<Reimbs> allreimbs = new ArrayList<Reimbs>();
		if (statusr.equals("approve")) {
			allreimbs = rdao.getReimbsByStatus(2);

		} else if (statusr.equals("deny")) {
			allreimbs = rdao.getReimbsByStatus(3);

		} else if (statusr.equals("pending")){
			allreimbs = rdao.getReimbsByStatus(1);

		} else {
			allreimbs = rdao.getReimbs();

		}
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(allreimbs));
	}
}
