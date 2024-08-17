package com.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.BookDao;
import com.bookstore.utils.Book;

@WebServlet("/get-all-books")
public class AllBooks extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Book> books = BookDao.getAllBooks();
		req.setAttribute("books", books);
		req.getRequestDispatcher("displaybooks.jsp").forward(req, resp);
		System.out.println();		
	}

}
