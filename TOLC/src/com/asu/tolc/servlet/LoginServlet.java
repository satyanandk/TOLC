package com.asu.tolc.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asu.tolc.entity.UserEntity;
import com.asu.tolc.model.ReplyService;
import com.asu.tolc.model.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String userName = (String)request.getParameter("userName");
		
		String password = (String)request.getParameter("password");
		
		
		UserService userService = new UserService(userName,password);
		try
		{
			UserEntity userEntity = userService.login();
			session.setAttribute("UserName", userName);
			session.setAttribute("UserEntity", userEntity);
			ReplyService rService = new ReplyService();
			HashMap<String,Integer> hMap = rService.createBadge(userName);
			session.setAttribute("Hmap", hMap);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("exception", e.getMessage());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
