package com.bookstore.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.utils.Book;

public class BookDao {

	private static final String URL = "jdbc:mysql://localhost:3306/books_db";
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD); 
				Statement st = con.createStatement()) {
				ResultSet resultSet = st.executeQuery("SELECT * FROM book");

			while (resultSet.next()) {
				Book book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				books.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return books;
	}
	
	public static Book getBookById(int bookId) {
		Book book = null;
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD); 
				PreparedStatement ps = con.prepareStatement("SELECT * FROM book WHERE id=?")) {
			
			ps.setInt(1, bookId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
				
	}
}
