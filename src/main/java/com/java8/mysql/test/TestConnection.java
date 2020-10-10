package com.java8.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main(String[] args) {
		
		
		Connection con=null;
		
		try {
			con =
				       DriverManager.getConnection("jdbc:mysql://localhost/sample_db?" +
				                                   "user=root&password=Vs1989@tcs");
			PreparedStatement ps=con.prepareStatement("select * from sample where age=?");
			ps.setString(1, "23");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+",");
				System.out.print("  "+rs.getString(2)+",");
				System.out.print("  "+rs.getString(3)+",");
				System.out.print("  "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
