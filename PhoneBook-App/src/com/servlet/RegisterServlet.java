package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		User user = new User(name, email, pass);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		
		boolean f = dao.UserRegister(user);
		
		
		HttpSession session = req.getSession();
		
		if(f){
			session.setAttribute("succMsg", "User Registered Successfully !!! ");
			// System.out.println("User Register4ed successfully");
			res.sendRedirect("register.jsp");
		}
		else{
			session.setAttribute("errMsg", "Something went wrong on server !!! ");
			res.sendRedirect("register.jsp");
			// System.out.println("Error");
		}
		
	}
	
}
