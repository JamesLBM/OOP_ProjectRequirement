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

public class Employee extends Manager{
	public void InsertOrder(int Order_No, int Book_Number, int SSN, int ID) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO Book_order(Order_No, Book_Number, SSN, ID)  VALUES(?,?,?,?)");
			insert.setInt(1, Order_No);
			insert.setInt(2, Book_Number);
                        insert.setInt(3, SSN);
			insert.setInt(4, ID);
			insert.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	public void InsertReceipt(int Receipt_No, int Order_No, int SSN, int ID) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO receipt(Receipt_No, Order_No, SSN, ID)  VALUES(?,?,?,?)");
			insert.setInt(1, Receipt_No);
			insert.setInt(2, Order_No);
                        insert.setInt(3, SSN);
			insert.setInt(4, ID);
			insert.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	public void ViewCurrentReceipt() {
		Connection database;
		
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("select * from receipt");
			ResultSet rs = insert.executeQuery();
			System.out.println("Receipt_No:  Order_No:  SSN:  ID:");
			System.out.println(rs.getObject("Receipt_No") + " " + rs.getObject("Order_No")+ " " + rs.getObject("SSN") + " " + rs.getObject("ID"));
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
}

