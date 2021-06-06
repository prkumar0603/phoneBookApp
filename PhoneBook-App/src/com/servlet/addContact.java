package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.ContactDAO;
import com.entity.Contact;

@WebServlet("/addContact")
public class addContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String about = req.getParameter("about");
		
		Contact contact = new Contact(name, email, phno, about, userId);
		ContactDAO dao = new ContactDAO(DBConnect.getConn());
		
		boolean f = dao.saveContact(contact);
		HttpSession session = req.getSession();
		if(f){
			session.setAttribute("succMsg", "Contact Saved Successfully !!! ");
			resp.sendRedirect("addContact.jsp");
		}
		else{
			session.setAttribute("errorMsg", "Something went wrong on server !!! ");
			resp.sendRedirect("addContact.jsp");
		}
	}
	
	

}
