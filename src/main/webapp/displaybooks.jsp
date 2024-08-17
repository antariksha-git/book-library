<%@page import="com.bookstore.utils.Book"%>
<%@page import="com.bookstore.utils.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
<style>
/* Style for the entire table */
table {
	width: 80%; /* Adjust the width of the table */
	margin: 20px auto; /* Center the table horizontally */
	border-collapse: collapse;
	/* Collapse borders to avoid double borders */
	font-family: Arial, sans-serif; /* Set a readable font */
}

/* Style for table headers */
th {
	background-color: #4CAF50; /* Green background for headers */
	color: white; /* White text color */
	padding: 10px; /* Add padding inside headers */
	text-align: left; /* Align text to the left */
}

/* Style for table rows */
tr:nth-child(even) {
	background-color: #f2f2f2; /* Light grey background for even rows */
}

tr:nth-child(odd) {
	background-color: #ffffff; /* White background for odd rows */
}

/* Style for table cells */
td {
	padding: 10px; /* Add padding inside cells */
	border: 1px solid #ddd; /* Light grey border for cells */
	text-align: left; /* Align text to the left */
}

/* Style for table borders */
table, th, td {
	border: 1px solid #ddd;
	/* Light grey border for table, headers, and cells */
}

/* Hover effect for rows */
tr:hover {
	background-color: #eaeaea; /* Slightly darker background on hover */
}
</style>
</head>
<body>

	<%
	List<Book> books = (List<Book>) request.getAttribute("books");
	List<Cart> carts = (List<Cart>) request.getAttribute("carts");
	%>

	<h2 style="text-align: center">Here are the list of books:</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Add to cart</th>
		</tr>
		<%
		for (Book book : books) {
		%>
		<tr>
			<td><%=book.getBookName()%></td>
			<td><%=book.getPrice()%></td>
			<td><a href="add-to-cart?bookId=<%=book.getBookid()%>">Add</a></td>
		</tr>

		<%
		}
		%>

	</table>

	<br>
	<br>
	<%
	double sum = 0;
	if (carts != null) {
	%>

	<h2 style="text-align: center">Your cart:</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<%
		for (Cart cart : carts) {
		%>

		<%
		sum += Double.parseDouble(cart.getPrice());
		%>
		<tr>
			<td><%=cart.getBookName()%></td>
			<td><%=cart.getPrice()%></td>
		</tr>

		<%
		}
		%>

	</table>
	
	<p> Your total is Rs. <%= sum%> </p>

		<%
		}
		%>

	

	<p></p>

</body>
</html>