package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.GiveFeedbackBean;
import com.beans.GiveQuestionsBean;
import com.beans.UserBean;
import com.dao.DBConnection;



public class DBConnection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qna", "root", "root");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return con;
		}

	}
	// Method for user Registration
	
	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static ResultSet getData1(String sql) {
		// TODO Auto-generated method stub
			Connection con = connect();
			ResultSet rs = null;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
	 
	 public static String getName(String sql) {
			// TODO Auto-generated method stub
			String name ="";
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					name = rs.getString(1);
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;

		}
	public static int setUser(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getMobile());
			ps.setString(4, ub.getPassword());
			ps.setString(5, "Pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int setWrite(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getMobile());
			ps.setString(4, ub.getPassword());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static int writeQuestions(String sql, GiveQuestionsBean gq) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, gq.getUid());
			ps.setString(2, gq.getQuestions());
		//	ps.setString(3, gq.getAnswers());
			ps.setString(3, gq.getDa());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getMyQuestionsDetails6(String sid) throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from writequestions where uid='"+sid+"'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	 public static ResultSet getMyQuestionsDetails2(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from answers where status3 ='Closed' and OID='"+sid+"' ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getMyQuestionsDetails5(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from writequestions where uid !='"+sid+"'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getMyQuestionsDetails(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from writequestions where uid !='"+sid+"' and status1='Open'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getMyQuestionsDetails9(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from answers where oid !='"+sid+"' and status3='Open'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getMyQuestionsDetails1(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from answers where oid ='"+sid+"' and status3='Open'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static boolean updateUser(String id) throws SQLException {
			String sql = "update writequestions set status1='Closed' where id='"+id+"'";
			Connection con = DBConnection.connect();
			Statement st = con.createStatement();
			boolean f = st.execute(sql);
			System.out.println("boolean is" + f);
			return f;
		}
	 public static boolean updateUser2(String id) throws SQLException {
			String sql = "update answers set status3='Closed' where id='"+id+"'";
			Connection con = DBConnection.connect();
			Statement st = con.createStatement();
			boolean f = st.execute(sql);
			System.out.println("boolean is" + f);
			return f;
		}
	 public static ResultSet getUserDetails( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where status7='Authorised'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDetails1( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where status7='Pending'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDetails2( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from unauthorised where status1='UnAuthorised'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getTrendingQuestionsDetails() throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select id,questions,count(id) from answers group by id having count(id)>1";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static int writeFeedback(String sql, GiveFeedbackBean gq) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, gq.getUid());
				ps.setString(2, gq.getFeedback());
				ps.setString(3, gq.getDa());
				i = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	 public static ResultSet getMyFeedbacks(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from feedback where uid='"+sid+"'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getAllFeedbacks( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from feedback ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 }
