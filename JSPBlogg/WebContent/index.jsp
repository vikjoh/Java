<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.List, java.sql.*, blog.*, java.util.ArrayList"%>
<% Class.forName("com.mysql.jdbc.Driver").newInstance(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Blog yo</title>
</head>
<body>
<% 
	ArrayList<Post> posts = (ArrayList<Post>) BlogFactory.getAllPosts();
	
	for(Post p : posts){
		out.print("<h1>");
		out.print(p.getTitle());
		out.print("</h1><p>");
		out.print(p.getText());
		out.print("</p>");
		out.print(p.getAuthor().getName() + ", " + p.printCalendar());
	}
%>
</body>
</html>