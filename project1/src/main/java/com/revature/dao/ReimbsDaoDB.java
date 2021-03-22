package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbs;
import com.revature.beans.User;
import com.revature.utils.ConnectionUtil;

public class ReimbsDaoDB implements ReimbsDao {
	
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private Connection con = cu.getConnection();
	
	public Reimbs addReimbs(Reimbs r) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO reimbursement(amount,submitted,description,statusid,rtypeid,author) values(?,?,?,?,?, (SELECT userid FROM users WHERE userid=?))";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmitted());
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getStatusid());
			ps.setInt(5, r.getRtypeid());
			ps.setInt(6, r.getAuthor());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	public Reimbs getReimbs(Integer reimbId) {
		// TODO Auto-generated method stub
		Reimbs reimb = new Reimbs();
		try {
			String sql = "SELECT * FROM reimbursement WHERE idreim = '"+reimbId+"';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				reimb.setIdreimb(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatusid(rs.getInt(8));
				reimb.setRtypeid(rs.getInt(9));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	public List<Reimbs> getReimbs() {
		// TODO Auto-generated method stub
		List<Reimbs> reimList = new ArrayList<Reimbs>();
		try {
			String sql = "SELECT * FROM reimbursement";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Reimbs reimb = new Reimbs();
				reimb.setIdreimb(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatusid(rs.getInt(8));
				reimb.setRtypeid(rs.getInt(9));
				
				reimList.add(reimb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimList;
	}

	public List<Reimbs> getReimbsByUser(User u) {
		// TODO Auto-generated method stub
		Integer useridofreim = u.getUid();
		List<Reimbs> reimList = new ArrayList<Reimbs>();
		try {
			String sql = "SELECT * FROM reimbursement WHERE author = '"+useridofreim+"';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Reimbs reimb = new Reimbs();
				reimb.setIdreimb(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatusid(rs.getInt(8));
				reimb.setRtypeid(rs.getInt(9));
				
				reimList.add(reimb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	public Reimbs updateReimb(Reimbs r) {
		// TODO Auto-generated method stub
		try {
			String sql1 = "UPDATE reimbursement set amount = ? , submitted = ? , resolved = ? , description = ? , author = ?, resolver = ?, statusid = ?, rtypeid = ? WHERE idreim = ?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmitted());
			ps.setTimestamp(3, r.getResolved());
			ps.setString(4, r.getDescription());
			ps.setInt(5, r.getAuthor());
			ps.setInt(6, r.getResolver());
			ps.setInt(7, r.getStatusid());
			ps.setInt(8, r.getRtypeid());
			ps.setInt(9, r.getIdreimb());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public boolean removeReimb(Reimbs r) {
		// TODO Auto-generated method stub
		boolean successful = false;
		try {
			String sql = "DELETE FROM reimbursement WHERE idreim = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getIdreimb());
			ps.execute();
			successful = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return successful;
	}

	@Override
	public List<Reimbs> getReimbsByStatus(Integer reimbStatus) {
		
		List<Reimbs> reimList = new ArrayList<Reimbs>();
		try {
			String sql = "SELECT * FROM reimbursement WHERE statusid = '"+reimbStatus+"';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Reimbs reimb = new Reimbs();
				reimb.setIdreimb(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getTimestamp(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatusid(rs.getInt(8));
				reimb.setRtypeid(rs.getInt(9));
				
				reimList.add(reimb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimList;
	}

}
