package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.AnswersBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class SendAnswers
 */
@WebServlet("/SendAnswers")
public class SendAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAnswers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession session =request.getSession();
		String qid=request.getParameter("qid");
		String oid=request.getParameter("oid");
		String questions=request.getParameter("questions");
		String odate=request.getParameter("date");
		String uid=(String)session.getAttribute("email");
		String answers=request.getParameter("answers");
		Date d = new Date();
		String da = "" + d;
		
		AnswersBean ab=new AnswersBean();
		ab.setDate(da);
		ab.setAnswers(answers);
	//	System.out.println(uid);
		System.out.println("kkkkkkkkk"+qid);
		System.out.println("kkkkkkkkk"+oid);
		System.out.println("kkkkkkkkk"+questions);
		System.out.println("kkkkkkkkk"+odate);
		System.out.println("kkkkkkkkk"+uid);
		System.out.println("kkkkkkkkk"+answers);
		System.out.println("kkkkkkkkk"+da);
	//	String Dkey=DBConnection.getkey(fid);
		Connection con=DBConnection.connect();
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into answers values('"+qid+"','"+oid+"','"+questions+"','"+odate+"','"+uid+"','"+answers+"','"+da+"','Open') ");
			
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Answer Sent Successfully ...');");
			 pw.println("location='AllQuestions.jsp';");
			 pw.println("</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/*
		PrintWriter pw=response.getWriter();
		HttpSession session =request.getSession();
		String qid=request.getParameter("qid");
		String oid=request.getParameter("oid");
		String questions=request.getParameter("questions");
		String odate=request.getParameter("date");
		String uid=(String)session.getAttribute("email");
		String answers=request.getParameter("answers");
		Date d = new Date();
		String da = "" + d;
		
		AnswersBean ab=new AnswersBean();
		ab.setDate(da);
		ab.setAnswers(answers);
	//	System.out.println(uid);
		System.out.println("kkkkkkkkk"+qid);
		System.out.println("kkkkkkkkk"+oid);
		System.out.println("kkkkkkkkk"+questions);
		System.out.println("kkkkkkkkk"+odate);
		System.out.println("kkkkkkkkk"+uid);
		System.out.println("kkkkkkkkk"+answers);
		System.out.println("kkkkkkkkk"+da);
	//	String Dkey=DBConnection.getkey(fid);
		Connection con=DBConnection.connect();
		try {
			PreparedStatement ps=con.prepareStatement("insert into answers values(?,?,?,?,?,?,?)");
			ps.setString(1,qid);
			ps.setString(2, oid);
			ps.setString(3,questions);
			ps.setString(4,odate);
			ps.setString(5, uid);
			ps.setString(6,answers);
			ps.setString(7,da);
		int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("AllQuestions.jsp?msg=Request sended successfully&&to=index.jsp");
			}
			else
			{
				response.sendRedirect("AllQuestions.jsp?msg=Faild to send request&&to=index.jsp");
			}
			pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Answer Sent Successfully ...');");
			 pw.println("location='AllQuestions.jsp';");
			 pw.println("</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
