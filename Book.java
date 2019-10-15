/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maint;

/**
 *
 * @author Moralde
 */
import java.sql.*;

public class Book {

	public void insertBook(int Book_Number, String Book_Name, String Author_Name, double Price, String Date_Published) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO Book(Book_Number, Book_Name, Author_Name, Price, Date_Published) VALUES(?,?,?,?,?)");	
			insert.setInt(1, Book_Number);
			insert.setString(2, Book_Name);
			insert.setString(3, Author_Name);
			insert.setDouble(4, Price);
			insert.setString(5, Date_Published);
			insert.execute();
			database.close();	
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void removeBook(int Book_Number) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement delete = database.prepareStatement("DELETE FROM Book WHERE Book_Number = ?");
			delete.setInt(1, Book_Number);
			delete.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void viewBook() {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("Select * from book");
			ResultSet rs = insert.executeQuery();
			System.out.println("BOOK NUMBER:  BOOK NAME:  AUTHOR'S NAME:  PRICE:  YEAR PUBLISHED:");
			while (rs.next()) {
				System.out.println(rs.getObject("Book_number") + " " + rs.getObject("Book_name")+ " " + rs.getObject("Author_name") + " " + rs.getObject("Price") + " " + rs.getObject("Date_published"));
			}
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookie", "root", "root");
			return conn;
			
		} catch (Exception e) {	
			System.out.println(e);
		}
		return null;
	}	
}

