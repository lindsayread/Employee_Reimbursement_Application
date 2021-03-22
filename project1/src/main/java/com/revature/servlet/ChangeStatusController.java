package com.revature.servlet;

import java.sql.Timestamp;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.dao.ReimbsDao;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;

public class ChangeStatusController {
	static UserDao udao = new UserDaoDB();
	static ReimbsDao rdao = new ReimbsDaoDB();
	
	public static String changestatus(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/managerhome.html";
		}
		System.out.println("in change status");
		String uname = (String) req.getSession().getAttribute("loggedusername");
		String password = (String) req.getSession().getAttribute("loggedpassword");
		User currentu = udao.getUser(uname, password);
		
		Integer reimbID = Integer.parseInt(req.getParameter("reimbid"));
		System.out.println(reimbID);
		Reimbs currentr = rdao.getReimbs(reimbID);
		System.out.println(currentr.getStatusid());
		String statusr = req.getParameter("approvalstatus");
		System.out.println("in addreimb, retrieving status");
		System.out.println(statusr);
		
		if (statusr.equals("approve")) {
			currentr.setStatusid(2);
		} else if (statusr.equals("deny")) {
			currentr.setStatusid(3);
		} else {
			currentr.setStatusid(1);
		}
		
		currentr.setResolved(Timestamp.from(Instant.now()));
		currentr.setResolver(currentu.getUid());
		rdao.updateReimb(currentr);
		System.out.println(currentr);

		return "managerhome.change";
	}
}
