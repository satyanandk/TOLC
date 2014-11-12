package com.asu.tolc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asu.tolc.model.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		System.out.println("User Name="+userName);
		
		String password = (String)request.getParameter("password");
		System.out.println("Passowrd = "+password);
		
		String emailID = (String)request.getParameter("email");
		String state = (String)request.getParameter("state");
		String notifications = (String)request.getParameter("notifications");
		UserService userService = new UserService(userName,password,emailID,state,notifications);
		try
		{
			userService.register();
			session.setAttribute("UserName", userName);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("exception", e.getMessage());
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
