package com.asu.tolc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.entity.UserEntity;
import com.asu.tolc.model.QuestionService;
import com.asu.tolc.model.UserService;

/**
 * Servlet implementation class PostQuestionServlet
 */
@WebServlet("/PostQuestionServlet")
public class PostQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostQuestionServlet() {
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
		request.removeAttribute("exception");
		HttpSession session = request.getSession(true);
		String userName = (String)session.getAttribute("UserName");
		
		String state = (String)request.getParameter("state");
		System.out.println("User Name="+state);
		
		String questionTitle = (String)request.getParameter("questionTitle");
		System.out.println("Passowrd = "+questionTitle);
		
		String question = (String)request.getParameter("question");
		
		QuestionService qs = new QuestionService(userName, questionTitle, question, state);
		
		try
		{
			qs.postQuestion();
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("exception", e.getMessage());
			request.getRequestDispatcher("PostQuestion.jsp").forward(request, response);
		}
	}

}
