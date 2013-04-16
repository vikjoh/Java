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
	int id = Integer.parseInt(request.getParameter("id"));
	
	BlogFactory.deletePost(id);
}
%>
<script>window.location = '/JSPBlogg';</script>