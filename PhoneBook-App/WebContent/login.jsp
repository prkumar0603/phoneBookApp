<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
</head>
<body style="background-color: #f7faf8">
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Login Page</h4>
						
						<%
							String errMsg = (String)session.getAttribute("errMsg");
							if(errMsg != null){
						%>
							<p class="text-danger text-center"><%= errMsg %></p>
						
						<%
							session.removeAttribute("errMsg");
							}
						%>
						
						<%
							String logMsg = (String)session.getAttribute("logMsg");
							if(logMsg != null){
						%>
							<p class="text-success text-center"><%= logMsg %></p>
						
						<%
							session.removeAttribute("logMsg");
							}
						%>
						
						
							
						<form action="login" method="POST">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<div class="text-center mt-2">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 150px">
		<%@include file="component/footer.jsp"%>
	</div>

</body>
</html>