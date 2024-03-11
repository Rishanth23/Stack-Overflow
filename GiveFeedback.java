package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.GiveFeedbackBean;
import com.beans.GiveQuestionsBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class GiveFeedback
 */
@WebServlet("/GiveFeedback")
public class GiveFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveFeedback() {
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
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession(false);
		String uid = (String) session.getAttribute("email");
		String feedback = request.getParameter("feedback");
		Date d = new Date();
		String da = "" + d;
		GiveFeedbackBean gq = new GiveFeedbackBean();
		gq.setUid(uid);
		gq.setFeedback(feedback);
		gq.setDa(da);
		String sql = "insert into feedback values(0,?,?,?)";
		int i = DBConnection.writeFeedback(sql, gq);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Feedback Added...');");
			o.println("window.location='SendFeedback.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='SendFeedback.jsp';</script>");
		}
		}
	}
