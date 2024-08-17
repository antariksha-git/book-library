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
import com.bookstore.utils.Cart;

public class CartDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/cart_db";
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
	
	public static void addToCart(Book book) {
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement("INSERT INTO cart VALUES(?, ?, ?)")) {
			
			ps.setInt(1, book.getBookid());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getPrice());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Cart> getAllInCart() {
		List<Cart> carts = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery("SELECT * FROM cart");
			
			while(rs.next()) {
				Cart cart = new Cart(rs.getInt(1), rs.getString(2), rs.getString(3));
				carts.add(cart);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
	}
	

}
