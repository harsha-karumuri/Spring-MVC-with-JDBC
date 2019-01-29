package com.accenture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.accenture.model.Customer;

public class CustomerDAO {
	
	public int addCustomer(Customer customer) {
		
		int rows=0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jpadb";
			Connection conn= DriverManager.getConnection(url,"root","root");
			
			String sql="INSERT INTO customer(customer_name,email,phone) VALUES(?,?,?)";
            
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			
			rows= ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

}
