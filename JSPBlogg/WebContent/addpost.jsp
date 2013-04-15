<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" import="java.util.List, java.sql.*, blog.*, java.util.ArrayList"%>
<% 
boolean loggedIn = false;
if (session.getAttribute("inloggad") == "admin")
{
	loggedIn = true;
}

if(loggedIn)
{
	String body = request.getParameter("body");
	String header = request.getParameter("header");
	
	Author auth = new Author("Victor Olsson");
	
	BlogFactory.addPost(header, body, auth);
}
%>
<script>window.location = '/JSPBlogg';</script>