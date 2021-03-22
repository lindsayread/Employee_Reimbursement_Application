package com.revature.driver;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.dao.ReimbsDao;
import com.revature.dao.ReimbsDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;

public class ReimbursementAppDriver {
	
	public static void main(String[] args) {
		UserDao udao = new UserDaoDB();
		ReimbsDao rdao = new ReimbsDaoDB();
		
		//testing UserDaoDB methods:
//		User user = new User();
//		user.setEmail("quizzz@gmail.com");
//		user.setFirstName("Qf");
//		user.setLastName("QL");
//		user.setPassword("qp");
//		user.setUsername("qe");
//		user.setUroleid(1);
////		
////		udao.addUser(user);
//		List<User> allus= udao.getAllUsers();
//		ArrayList unames = new ArrayList();
//		for (User u : allus) {
//			System.out.println(u);
//			System.out.println(u.getUsername());
//			unames.add(u.getUsername());
//		}
//		System.out.println(unames);
//		if (unames.contains(user.getUsername())) {
//			System.out.println("username already exists");
//		} else {
//			udao.addUser(user);
//		}
		System.out.println(udao.getUser("tuname", "tesp"));
		//System.out.println(udao.getAllUsers());
//		
//		User u2 = new User();
//		u2.setEmail("temail");
//		u2.setFirstName("lindsa");
//		u2.setLastName("read");
//		u2.setPassword("pwordssss");
//		u2.setUsername("lres");
//		u2.setUroleid(2);
//		
//		udao.addUser(u2);
		
//		udao.addUser(user); WORKS
		//System.out.println(udao.getUser(1)); WORKS
		//System.out.println(udao.getUser("tuname", "tesp")); WORKS
		//System.out.println(udao.getAllUsers()); WORKS
		//remove user:
		//udao.removeUser(udao.getUser(1)); WORKS
		//System.out.println(udao.getAllUsers());
		
		//testing ReimbsDaoDB methods:
//		Reimbs reimb = new Reimbs();
//		reimb.setAmount(22.22);
//		reimb.setAuthor(3);
//		reimb.setDescription("pls reimburse");
//		reimb.setRtypeid(1);
//		reimb.setStatusid(1);
//		//String TIME_FORMAT
//		reimb.setSubmitted(Timestamp.from(Instant.now()));
//		//reimb.setSubmitted(Timestamp.valueOf(LocalDateTime.now().format("yyyy-MM-dd HH:mm:ss")));
//		//System.out.println(reimb);
//		rdao.addReimbs(reimb); WORKS
		//System.out.println(rdao.getReimbs(3)); WORKS BUT MAY WANT TO THROW EXCEPTION IF REIMBID DOES NOT EXIST
		//System.out.println(rdao.getReimbs()); WORKS
		//System.out.println(rdao.getReimbsByUser(udao.getUser(3))); WORKS
		//rdao.removeReimb(rdao.getReimbs(4)); WORKS
		//System.out.println(rdao.getReimbs());
		
		//testing get reimbs by status:
		System.out.println(rdao.getReimbsByStatus(2));
		//rdao.getReimbsByStatus(1);
	}
}
