package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.User;
import com.revature.utils.ConnectionUtil;


public class UserDaoDB implements UserDao {
	
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private Connection con = cu.getConnection();


	public User addUser(User user) {
		try {
			String sql = "INSERT INTO users(username,pword,firstname,lastname,email,uroleid) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getUroleid());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public User getUser(Integer userId) {
		User user = new User();
		try {
			String sql = "SELECT * FROM users WHERE userid = '"+userId+"';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				user.setUid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUroleid(rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(String username, String pass) {
		User user = new User();
		try {
			String sql = "SELECT * FROM users WHERE username='"+username+"' and pword='"+pass+"';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				user.setUid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUroleid(rs.getInt(7));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getAllUsers() {
		List<User> allusers = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM users";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUroleid(rs.getInt(7));
				
				allusers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allusers;
	}

	public User updateUser(User u) {
		try {
			String sql1 = "UPDATE users set username = ? , pword = ? , firstname = ? , lastname = ? , email = ?, uroleid = ? WHERE userid = ?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUroleid());
			
			ps.setInt(7, u.getUid());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public boolean removeUser(User u) {
		boolean successful = false;
		try {
			String sql = "DELETE FROM users WHERE username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.execute();
			successful = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return successful;
	}
	
}
