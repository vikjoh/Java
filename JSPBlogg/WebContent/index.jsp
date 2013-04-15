<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" import="java.util.List, java.sql.*, blog.*, java.util.ArrayList"%>
<% 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
boolean loggedIn = false;
if(session.getAttribute("inloggad") == "admin")
{
	loggedIn = true;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="standard.css">
<title>Blog yo</title>
</head>
<body>

<section id="login">

<% if(loggedIn){ %>
	
	<form name="input" action="login.jsp" method="post">
		<input type="submit" value="Logga ut">
	</form> 
	
<% } else { %>
	<form name="input" action="login.jsp" method="post">
		<table>
			<tr>
				<td>
					Username:
				</td>
				<td>
					<input type="text" name="username"><br>
				</td>
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<input type="submit" value="Logga in">
				</td>
			</tr>
		</table>
	</form>
<% } %>

</section>

<% if(loggedIn){ %>
	<form name="input" action="addpost.jsp" method="post">
	<table>
		<tr>
			<td>
				Titel:
			</td>
			<td>
				<input type="text" name="header"><br>
			</td>
		</tr>
		<tr>
			<td>
				Brödtext:
			</td>
			<td>
				<textarea name="body"></textarea>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" value="Skicka">
			</td>
		</tr>
	</table>
</form>

<%	
}
%>

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