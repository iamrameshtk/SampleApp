<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- LLPP714 -->
<%@ page import="java.io.*,java.util.*, java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ff6600" style="text-align: center;">

<h3 color="white">Welcome <font color="green"><% out.println(request.getParameter("name")); %></font><br>
!!!Dont share your Password:



<%! static int hit=0; %>
<%
if (hit == 0) 
{
%>
<h4><%
hit ++;
out.println("Welcome Visitor"); %> <br> 
<% out.println("Visitor Number : ");%> <%=hit %>.</h4>
<% 
hit++;
}
else
{
%>
<h4><% out.print("Welcome Visitor, Visitor Number : "); %> <%=hit %>.</h4>
<%
hit++;
}
%>
</body>
</html>