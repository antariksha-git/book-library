package com.bookstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.UserDao;
import com.bookstore.utils.User;

@WebServlet("/login-user")
public class LoginAuthenticate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		
		if(UserDao.findUserByEmailAndPassword(userEmail, userPassword) != null) {
			resp.sendRedirect("get-all-books");
		} else {
			resp.getWriter().println("<h1>Authentication failed!</h1>");
		}
	}
}
