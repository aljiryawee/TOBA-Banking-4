package com.toba.banking;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

	Logger logger = Logger.getLogger(LoginServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.getRequestDispatcher("/WEB-INF/views/login.html").forward(request, response);
		// throw new ServletException("Hello World");
	}

	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * String username = request.getParameter("username"); String password =
	 * request.getParameter("password");
	 * 
	 * User user = new User(); user.setUsername(username);
	 * user.setPassword(password); user.setFirstName("J.");
	 * user.setLastName("Smith");
	 * 
	 * HttpSession httpSession = request.getSession();
	 * httpSession.setAttribute("user", user);
	 * 
	 * if(username.equals("jsmith@toba.com") && password.equals("letmein"))
	 * request.getRequestDispatcher("/WEB-INF/views/account_activity.jsp").
	 * forward(request, response); else
	 * request.getRequestDispatcher("/WEB-INF/views/login_failure.html").forward
	 * (request, response); }
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String url = "/WEB-INF/views/index.jsp";
		HttpSession session = request.getSession();

		String password = request.getParameter("password");
		String username = request.getParameter("username");
		logger.log(Level.INFO, "Username "+username+"\tPassword "+password);
		logger.log(Level.INFO, "User Exists "+UserDB.userExists(username));
		System.out.println("User Exists "+UserDB.userExists(username));
		if (UserDB.userExists(username)) {
			User user = UserDB.selectUser(username);
			session.setAttribute("user", user);
			if (password.equals(user.getPassword()) && username.equals(user.getUsername())) {
				url = "/WEB-INF/views/account_activity.jsp";

			} else {
				url = "/WEB-INF/views/login_failure.jsp";
				response.setStatus(400);
				session.invalidate();
			}
		}else{
			response.setStatus(400);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}