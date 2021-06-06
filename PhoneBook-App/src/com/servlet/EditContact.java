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

@WebServlet("/update")
public class EditContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid = Integer.parseInt(req.getParameter("cid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String about = req.getParameter("about");
		
		ContactDAO dao = new ContactDAO(DBConnect.getConn());
		Contact contact = new Contact();
		contact.setId(cid);
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhno(phno);
		contact.setAbout(about);
		
		
		boolean f = dao.updateContact(contact);
		HttpSession session = req.getSession();
		if(f){
			session.setAttribute("succMsg", "Contact Updated Successfully !!! ");
			resp.sendRedirect("viewContact.jsp");
		}
		else{
			session.setAttribute("errorMsg", "Something went wrong on server !!! ");
			resp.sendRedirect("editContact.jsp?cid="+cid);
		}
	}
	
	
}
