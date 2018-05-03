package com.toba.banking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResetPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String url = "/account_activity.jsp";

		String action = request.getParameter("action");
		if (action == null) {
			action = "reset";
		}
		if (action.equals("reset")) {

			String password = request.getParameter("password");
			String message;

			user.setPassword(password);
			message = "";
			url = "/account_activity.jsp";
			session.setAttribute("user", user);

			request.setAttribute("message", message);
			UserDB.update(user);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
