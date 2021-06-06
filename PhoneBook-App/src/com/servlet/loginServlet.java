package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		User user = dao.UserLogin(email, pass);
		
		HttpSession session = req.getSession();
		
		if(user != null){
			// System.out.println("User is available "+user);
			session.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		}
		else{
			// System.out.println("User is Unavailable ");
			session.setAttribute("errMsg","Invalid Email or Password");
			resp.sendRedirect("login.jsp");
		}
	}
	
}
