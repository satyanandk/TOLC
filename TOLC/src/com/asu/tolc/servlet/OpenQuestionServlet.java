package com.asu.tolc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.entity.ReplyEntity;
import com.asu.tolc.model.QuestionService;
import com.asu.tolc.model.ReplyService;

/**
 * Servlet implementation class OpenQuestionServlet
 */
@WebServlet("/OpenQuestionServlet")
public class OpenQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Question No = asda");
		String questionNo = (String)request.getParameter("questionNum");
		HttpSession session = request.getSession(true);
		System.out.println("Question No = "+questionNo);
		
		int qNo = Integer.parseInt(questionNo);
		
		QuestionService qService = new QuestionService();
		ReplyService rService = new ReplyService();
		try {
			QuestionEntity qEntity = qService.getQuestion(qNo);
			session.setAttribute("QuestionEntity", qEntity);
			
			List<ReplyEntity> replyList = rService.getReplies(qNo);
			
			session.setAttribute("ReplyList", replyList);
			
			request.getRequestDispatcher("QuestionReply.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Question No = POSTTTTT");
		doGet(request, response);
	}

}
