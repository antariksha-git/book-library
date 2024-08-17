package com.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.BookDao;
import com.bookstore.models.CartDao;
import com.bookstore.utils.Book;
import com.bookstore.utils.Cart;

@WebServlet("/add-to-cart")
public class AddCart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		Book book = BookDao.getBookById(bookId);
		CartDao.addToCart(book);
		
		//System.out.println(bookId);
		
		List<Book> books = BookDao.getAllBooks();
		req.setAttribute("books", books);
		List<Cart> carts = CartDao.getAllInCart();
		req.setAttribute("carts", carts);
		
		req.getRequestDispatcher("displaybooks.jsp").forward(req, resp);;
		
	}
}
