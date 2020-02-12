package com.login.LoginDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.input.Logininput;

public class LoginDao {
	public boolean validate(Logininput logininput) throws ClassNotFoundException {
        boolean status = false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manju");
			PreparedStatement p=c.prepareStatement("Select * from login where username=? and password=?");
			p.setString(1,logininput.getUsername());
			p.setString(2,logininput.getPassord());
			System.out.println(p);
		    ResultSet r=p.executeQuery();
		   status=r.next();
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return status;
		
	}
	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	

}
