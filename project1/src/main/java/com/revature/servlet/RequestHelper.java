package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.FilterByController;
import com.revature.controllers.LogOutController;
import com.revature.controllers.LoginController;
import com.revature.controllers.RegistrationPageController;
import com.revature.controllers.ReimbursementController;

public class RequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse res) {
		 System.out.println(req.getRequestURI());
		 switch(req.getRequestURI()) {
		 case "/project1/login.change":
			 
			 return LoginController.login(req, res);
		 case "/project1/register.change":
			 
			 return "resources/html/register.html";
		 case "/project1/userhome.change":
			 return "resources/html/userhome.html";
		 case "/project1/registrationsuccess.change":
			 return RegistrationPageController.registerp(req);
		 case "/project1/registrationsuccessful.change":
			 return "/project1";
		 case "/project1/usernamealreadyexists.change":
			 return "resources/html/usernamealreadyexists.html";
		 case "/project1/NewReimbursement.change":
			 return "resources/html/NewReimbursement.html";
		 case "/project1/AddReimbursement.change":
			 return ReimbursementController.addreimb(req);
		 case "/project1/managerhome.change":
			 return "resources/html/managerhome.html";
		 
		 case "/project1/changestatus.change":
			 return ChangeStatusController.changestatus(req);
			 
		 case "/project1/filterby.change":
			 return FilterByController.filterby(req, res);
		 case "/project1/filteredhome.change":
			 return "resources/html/filteredhome.html";
			 
		 case "/project1/logout.change":
			 //return LogOutController.logout(req);
			 return "resources/html/index.html";
			 
		default:
			System.out.println("In default");
			return "resources/html/unsuccessfullogin.html";
		 }
		 
	 }
}
