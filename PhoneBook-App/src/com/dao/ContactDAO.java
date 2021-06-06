package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDAO{
	
	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean saveContact(Contact contact){
		boolean f = false;
		String id = String.valueOf(Math.floor(Math.random() * 1000) + 1);
		
		try {
			String query = "insert into contact(id, name, email, phno, about, userid) values(?,?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getPhno());
			ps.setString(5, contact.getAbout());
			ps.setInt(6, contact.getUserId());
			
			int i = ps.executeUpdate();
			if(i == 1){
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public List<Contact> getAllContact(int uid){
		List<Contact> list = new ArrayList<>();
		Contact contact = null;
		
		try {
			String query = "select * from contact where userid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				contact = new Contact();
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setPhno(rs.getString(4));
				contact.setAbout(rs.getString(5));
				
				list.add(contact);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Contact getContactByID(int cid){
		Contact contact = new Contact();
		
		try {
			String query = "select * from contact where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setPhno(rs.getString(4));
				contact.setAbout(rs.getString(5));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contact;
	}
	
	public boolean updateContact(Contact contact){
		boolean f = false;
		
		try {
			String query = "update contact set name=?,email=?,phno=?,about=? where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhno());
			ps.setString(4, contact.getAbout());
			ps.setInt(5, contact.getId());
			
			int i = ps.executeUpdate();
			if(i == 1){
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public boolean deleteContactById(int id){
		boolean f = false;
		
		try {
			String query = "delete from contact where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i==1){
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
}
