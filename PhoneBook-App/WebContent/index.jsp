<%@page import="com.entity.User"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>

<style type="text/css">
	.back-img {
		background : url("img/phone.jpeg");
		width : 100%;
		height : 83vh;
		background-size : contain;
	}

</style>

</head>
<body>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<%@include file="component/navbar.jsp" %>

	<div class="container-fluid back-img text-center text-white">
		<h1>Welcome to PhoneBook App</h1>
	</div>

	<%@include file="component/footer.jsp" %>
</body>
</html>