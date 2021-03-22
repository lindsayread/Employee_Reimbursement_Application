package com.revature.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbs;
import com.revature.controllers.FilterByController;


public class JSONRequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException,
	IOException{
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/project1/retrievereimbs.json":
			ShowReimbsController.showReimbs(req, res);
			return "/resources/html/userhome.html";
			//break;
		case "/project1/managerreimbs.json":
			ManagerReimbsController.showReimbs(req, res);
			return "/resources/html/managerhome.html";
		
		case "/project1/filterby.json":
			System.out.println("directed to filteredreimbs.json");
			FilterReimbsJSON.filterReimbs(req,res);
			return "/resources/html/filteredhome.html";
		default:
			Reimbs reim = new Reimbs();
			res.getWriter().write(new ObjectMapper().writeValueAsString(reim));
			return "/resources/html/userhome.html";
		}
		
	}
}
