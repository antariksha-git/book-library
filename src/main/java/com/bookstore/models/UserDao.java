package com.bookstore.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bookstore.utils.User;

public class UserDao {

	private static final String URL = "jdbc:mysql://localhost:3306/users_db";
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

	public static void saveUser(User user) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES(?, ?)")) {

			ps.setString(1, user.getUserEmail());
			ps.setString(2, user.getUserPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static User findUserByEmailAndPassword(String email, String password) {

		User user = null;

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE email=? and password=?")) {

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			String userEmail = null;
			String userPassword = null;

			if (rs.next()) {
				userEmail = rs.getString(1);
				userPassword = rs.getString(2);
			}

			if (password.equals(userPassword)) {
				user = new User(userEmail, userPassword);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}

}
