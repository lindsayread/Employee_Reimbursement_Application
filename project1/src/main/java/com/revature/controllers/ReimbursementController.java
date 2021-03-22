package com.revature.controllers;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.dao.ReimbsDao;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.utils.SessionCache;

public class ReimbursementController {
	
	static UserDao udao = new UserDaoDB();
	static ReimbsDao rdao = new ReimbsDaoDB();
	
	public static String addreimb(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/userhome.html";
		}
		System.out.println("in reimbursementcontroller");
		String uname = (String) req.getSession().getAttribute("loggedusername");
		String password = (String) req.getSession().getAttribute("loggedpassword");
		User currentu = udao.getUser(uname, password);
		
		Double amount = Double.parseDouble(req.getParameter("amount"));
		String description = req.getParameter("description");
		String rtype = req.getParameter("rtype");
		System.out.println(amount);
		System.out.println(description);
		System.out.println(rtype);
		
		Reimbs r = new Reimbs();
		//set reimbursement attributes:
		r.setAmount(amount);
		r.setAuthor(currentu.getUid());
		r.setDescription(description);
		r.setStatusid(1);
		r.setSubmitted(Timestamp.from(Instant.now()));
		
		if (rtype.equals("travel")) {
			r.setRtypeid(3);
		} else if (rtype.equals("food")){
			r.setRtypeid(2);
		} else if (rtype.equals("lodging")) {
			r.setRtypeid(1);
		} else {
			r.setRtypeid(4);
		}
		rdao.addReimbs(r);
		System.out.println(r);
		return "userhome.change";
	}
}
