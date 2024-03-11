package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String uid = request.getParameter("email");
		String pwd = request.getParameter("password");
		HttpSession session = request.getSession();
	    System.out.println("username and password"+uid+pwd);
		
		Connection con=DBConnection.connect();
			try {
				String sql = "select * from user where email='"+uid+"' and password='"+pwd+"' and status7='Authorised'";
				if(DBConnection.getData(sql) == true){
					session.setAttribute("email", uid);
					sql = "select name from user where email='"+uid+"'";
					String name = DBConnection.getName(sql);
					session.setAttribute("name", name);
					response.sendRedirect("UserHome.jsp");
				}
				else{
					Statement st=con.createStatement();
				    int i=st.executeUpdate("insert into unauthorised values(0,'"+uid+"','UnAuthorised') ");
				    pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Un-Authorised Access Detected...');");
					pw.println("window.location='Login.jsp';</script>");
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
