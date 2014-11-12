package com.asu.tolc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;

import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.model.QuestionService;

/**
 * Servlet implementation class PostReplyServlet
 */
@WebServlet("/PostReplyServlet")
public class PostReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		List<QuestionEntity> questionEntityList;
		QuestionService qs = new QuestionService();
		try {
			questionEntityList = qs.getQuestions();
			session.setAttribute("QuestionEntityList", questionEntityList);
			request.getRequestDispatcher("PostReply.jsp").forward(request, response);
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
	}

}
