package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean UserRegister(User user){
		boolean f = false;
		String id = String.valueOf(Math.floor(Math.random() * 1000) + 1);
		
		try{
			String query = "insert into phoneuser(id, name, email, password) values(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			int i = ps.executeUpdate();
			if(i == 1){
				f = true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User UserLogin(String e, String p){
		
		User user = null;
		
		try {
			String query = "select * from phonebook where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, e);
			ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return user;
	}

}
