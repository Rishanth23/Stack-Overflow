package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnection;

/**
 * Servlet implementation class Approve
 */
@WebServlet("/Approve")
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String uid=request.getParameter("cemailid");
		String id=request.getParameter("id");
		System.out.println("value from html"+id);
		try {
			boolean f=DBConnection.updateUser(id);
			System.out.println("boolean in sevlet"+f);
			if(!f) {
				System.out.println("true");
				response.sendRedirect("MyQuestions.jsp");
				
				
				
			}else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String id=request.getParameter("id");
		System.out.println("value from html"+id);
		try {
			boolean f=DBConnection.updateUser(id);
			System.out.println("boolean in sevlet"+f);
			if(!f) {
				System.out.println("true");
				boolean f2=DBConnection.updateUser2(id);
				if(!f2)
				{
					System.out.println("true 2");
					response.sendRedirect("MyQuestions.jsp");
				}
			}else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
