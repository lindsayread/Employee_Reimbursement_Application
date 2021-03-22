package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDaoDB;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.utils.SessionCache;

public class UserServices {
	UserDaoDB userDao;
//	AccountDao accountDao;
	
	public UserServices(UserDaoDB udao) {
		this.userDao = udao;
//		this.accountDao = adao;
	}
	
	/**
	 * Validates the username and password, and return the User object for that user
	 * @throws InvalidCredentialsException if either username is not found or password does not match
	 * @return the User who is now logged in
	 */
	public User login(String username, String password) {
		User currentuser = userDao.getUser(username, password);
		if (currentuser!=null) {
			SessionCache.setCurrentUser(currentuser);
			return currentuser;
		}
		else {
			throw new InvalidCredentialsException();
		}

	}
	
	/**
	 * Creates the specified User in the persistence layer
	 * @param newUser the User to register
	 * @throws UsernameAlreadyExistsException if the given User's username is taken
	 */
	public void register(User newUser) {

		if ((this.userDao.getUser(newUser.getUsername(), newUser.getPassword()))!=null) {
			throw new UsernameAlreadyExistsException();
		}
		else {
			this.userDao.addUser(newUser);
		}
		List<User> allus= userDao.getAllUsers();
		ArrayList unames = new ArrayList();
		for (User u : allus) {
			System.out.println(u);
			System.out.println(u.getUsername());
			unames.add(u.getUsername());
		}
		System.out.println(unames);
		if (unames.contains(newUser.getUsername())) {
			throw new UsernameAlreadyExistsException();
			//System.out.println("username already exists");
		} else {
			userDao.addUser(newUser);
			System.out.println("user added");
		}
	}
}
