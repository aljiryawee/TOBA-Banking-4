package com.toba.banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewCustomerServlet
 */
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewCustomerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();

		User user = (User) httpSession.getAttribute("user");

		user.setPassword(request.getParameter("password"));

		httpSession.setAttribute("user", user);

		response.sendRedirect("/WEB-INF/views/account_activity.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");

		if (firstName.length() > 0 && lastName.length() > 0 && phone.length() > 0 && address.length() > 0
				&& city.length() > 0 && state.length() > 0 && zipcode.length() > 0 && email.length() > 0) {

			User user = new User();
			user.setUsername(lastName + zipcode);
			user.setPassword("welcome1");
			user.setFirstname(firstName);
			user.setLastname(lastName);
			user.setPhone(phone);
			user.setAddress(address);
			user.setCity(city);
			user.setState(state);
			user.setZipcode(zipcode);
			user.setEmail(email);

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			
			UserDB.insert(user);

			request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Please fill out all the form fields.");
			request.getRequestDispatcher("/WEB-INF/views/new_customer.jsp").forward(request, response);
		}
	}

	/*@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();

		User user = (User) httpSession.getAttribute("user");

		user.setPassword(request.getParameter("password"));

		httpSession.setAttribute("user", user);

		response.sendRedirect("/WEB-INF/views/account_activity.html");
	}*/

}
