package com.revature.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbs;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDaoDB;

public class ManagerReimbsController {
	static UserDaoDB udao = new UserDaoDB();
	static ReimbsDaoDB rdao = new ReimbsDaoDB();
	
	public static void showReimbs(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{

		List<Reimbs> allreimbs = rdao.getReimbs();
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(allreimbs));
	}
}
