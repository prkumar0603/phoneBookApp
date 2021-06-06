<%@page import="com.entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ContactDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		if (user == null) {
			session.setAttribute("errMsg", "Please Login... ");
			response.sendRedirect("login.jsp");
		}
	%>

	<%
		String succMsg = (String) session.getAttribute("succMsg");
		String errMsg = (String) session.getAttribute("errorMsg");
		if (succMsg != null) {
	%>
		<div class="alert alert-success" role="alert"><%=succMsg%></div>
	<%
		session.removeAttribute("succMsg");
		}
		
		if (errMsg != null) {
	%>
		<p class="text-danger text-center"><%=errMsg%></p>
	<%
		session.removeAttribute("errorMsg");
		}
	%>

	<div class="container">
		<div class="row p-4">

			<%
				if (user != null) {

					ContactDAO dao = new ContactDAO(DBConnect.getConn());
					List<Contact> contacts = dao.getAllContact(user.getId());

					for (Contact contact : contacts) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name :
							<%=contact.getName()%>
						</h5>
						<p>
							Phone Number :
							<%=contact.getPhno()%></p>
						<p>
							email :
							<%=contact.getEmail()%></p>
						<p>
							about :
							<%=contact.getAbout()%></p>

						<div class="text-center">
							<a href="editContact.jsp?cid=<%=contact.getId()%>"
								class="btn btn-success btn-sm text-white">Edit</a> <a
								href="delete?cid=<%=contact.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
				}
			%>


		</div>
	</div>

</body>
</html>