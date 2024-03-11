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

import com.beans.GiveQuestionsBean;
import com.beans.UserBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class GiveQuestions
 */
@WebServlet("/GiveQuestions")
public class GiveQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveQuestions() {
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
		String questions = request.getParameter("questions");
	//	String answers = request.getParameter("answers");
		Date d = new Date();
		String da = "" + d;
		String status1=request.getParameter("status1");
		String status2=request.getParameter("status2");
		GiveQuestionsBean gq = new GiveQuestionsBean();
		gq.setUid(uid);
		gq.setQuestions(questions);
	//	gq.setAnswers(answers);
		gq.setDa(da);
		gq.setStatus1(status1);
		gq.setStatus2(status2);
		System.out.println(uid+" "+questions+" "+da);
		String sql = "insert into writequestions values(0,?,?,?,'Open')";
		int i = DBConnection.writeQuestions(sql, gq);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Response Register Successfully...');");
			o.println("window.location='GiveQuestions.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='GiveQuestions.jsp';</script>");
		}
		}
	}

