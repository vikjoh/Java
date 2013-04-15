<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" import="java.util.List, java.sql.*, blog.*, java.util.ArrayList"%>
<% 
String tryName = request.getParameter("username");
String tryPass = request.getParameter("password");

String rightName = "admin";
String rightPass = "pass";

if (session.getAttribute("inloggad") == "admin")
{
	session.setAttribute("inloggad", null);
} 
else if(tryName.equals(rightName) && tryPass.equals(rightPass)) 
{
	session.setAttribute("inloggad", "admin");
}
%>
<script>window.location = '/JSPBlogg';</script>