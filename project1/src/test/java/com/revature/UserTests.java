package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.services.UserServices;

public class UserTests {
	
//	@InjectMocks
	public UserServices userSrv;
	
//	@Mock
	public UserDaoDB udao;
	
//	@Before
//	public void setupMocks() {
//		User mockUser = new User();
//		mockUser.setUsername("testuser");
//		mockUser.setPassword("testpassword");
//		mockUser.setEmail("testemail");
//		mockUser.setFirstName("testFirst");
//		mockUser.setLastName("testLast");
//		mockUser.setUroleid(1);
//		
//		udao.addUser(mockUser);
//		// DAO layer will only retrieve "testuser" -> simulating only this user existing in persistence layer
//		when(udao.getUser(anyString(), anyString())).then(invocation -> {
//			String uname = invocation.getArgument(0);
//			String pw = invocation.getArgument(1);
//			if (uname.equals("testuser") && pw.equals("testpassword")) {
//				return mockUser;
//			} else {
//				return null;
//			}
//		});
//	}
	/*
	 * This test uses mocking to test that the DAO layer is being called once to login
	 */
	@Test
	
	public void testLoginWithValidCredentials() {
//		String username = "testuser";
//		String pw = "testpassword";
		User mockUser = new User();
		mockUser.setUsername("testuser");
		mockUser.setPassword("testpassword");
		mockUser.setEmail("testemail");
		mockUser.setFirstName("testFirst");
		mockUser.setLastName("testLast");
		mockUser.setUroleid(1);
		
		udao.addUser(mockUser);
		User user = userSrv.login("testuser", "testpassword");
		assertNotNull(user);
		verify(udao, times(1)).getUser("testuser", "testpassword");
	}
	
	/*
	 * This is an example of a negative test. Here, we want to ensure that we are properly
	 * rejecting invalid credentials and preventing unauthorized logins
	 */
	@Test(expected=InvalidCredentialsException.class)
	
	public void testLoginWithInvalidCredentials() {
		String username = "wrong";
		String pw = "credentials";
		userSrv.login(username, pw);
	}
	
	@Test
	
	public void testRegistration() {
		String uname = "registrationTester";
		String pw = "abcdef";
		User newUser = new User();
		newUser.setUsername(uname);
		newUser.setPassword(pw);
		newUser.setEmail("email@email.email");
		newUser.setFirstName("FirstNamemockito");
		newUser.setLastName("LastNameMockito");
		newUser.setUroleid(1);
		userSrv.register(newUser);
		verify(udao, times(1)).addUser(newUser);
	}
	
	@Test(expected=UsernameAlreadyExistsException.class)
	
	public void testInvalidRegistration() {
		String uname = "testuser";
		// try registration with same username - this should fail
		User anotherUser = new User();
		anotherUser.setUsername(uname);
		anotherUser.setPassword("testpassword");
		anotherUser.setEmail("email@email.email");
		anotherUser.setFirstName("FirstNamemockito");
		anotherUser.setLastName("LastNameMockito");
		anotherUser.setUroleid(1);
		userSrv.register(anotherUser);
	}
}
