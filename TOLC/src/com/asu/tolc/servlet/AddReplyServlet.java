package com.asu.tolc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asu.tolc.entity.QuestionEntity;
import com.asu.tolc.model.ReplyService;

/**
 * Servlet implementation class AddReplyServlet
 */
@WebServlet("/AddReplyServlet")
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReplyServlet() {
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
		
		HttpSession session = request.getSession(true);
		String userName = (String)session.getAttribute("UserName");
		String reply = (String)request.getParameter("reply");
		String category = (String)request.getParameter("category");
		String button = request.getParameter("action").toString();
		QuestionEntity qEntity = (QuestionEntity)session.getAttribute("QuestionEntity");
		if(button.equals("Subscribe"))
		{
			ReplyService rService = new ReplyService();
			rService.subscribe(userName, qEntity.getQuestionNo());
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		else if(button.equals("PostReply"))
		{
			
			ReplyService rService = new ReplyService();
			try {
				rService.postReply(userName, qEntity.getQuestionNo(),reply,category );
				System.out.println("in controller");
				RequestDispatcher rd =
					    this.getServletConfig()
					        .getServletContext()
					        .getRequestDispatcher("/OpenQuestionServlet1?questionNum="+qEntity.getQuestionNo());
					rd.forward(request, response);
				//request.getRequestDispatcher("/OpenQuestionServlet1?questionNum="+qEntity.getQuestionNo()+"").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("QuestionReply.jsp").forward(request, response);
			}
		}
	}

}
