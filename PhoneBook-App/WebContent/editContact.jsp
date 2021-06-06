<%@page import="com.entity.Contact"%>
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

	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Contact Page</h4>

						<%
							/* String succMsg = (String) session.getAttribute("succMsg"); */
							String errMsg = (String) session.getAttribute("errorMsg");

							if (errMsg != null) {
						%>
						<p class="text-danger text-center"><%=errMsg%></p>
						<%
							session.removeAttribute("errorMsg");
							}
						%>

						<form action="update" method="POST">

							<%
								// getting cid from url
								int cid = Integer.parseInt(request.getParameter("cid"));
								ContactDAO dao = new ContactDAO(DBConnect.getConn());
								Contact contact = dao.getContactByID(cid);	
							%>
							
							<input type="hidden" value="<%=cid%>" name="cid">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									value="<%=contact.getName()%>" name="name" type="text"
									class="form-control" id="exampleInputName1"
									aria-describedby="emailHelp" placeholder="Enter Name">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									value="<%=contact.getEmail()%>" name="email" type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Phone Number</label> <input
									value="<%=contact.getPhno()%>" name="phno" type="number"
									class="form-control" id="exampleInputPhone1"
									aria-describedby="emailHelp" placeholder="Enter Phone Number">
							</div>

							<div class="form-group">
								<label for="exampleFormControlTextarea1">Enter About</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									name="about" rows="3" placeholder="Enter About"><%=contact.getAbout()%></textarea>
							</div>

							<div class="text-center mt-2">
								<button type="submit" class="btn btn-success">Update
									Contact</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 2px">
		<%@include file="component/footer.jsp"%>
	</div>

</body>
</html>