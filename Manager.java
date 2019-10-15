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

public class Manager extends Book{

	public void insertEmployee(int SSN, String EName, String ESex, String EAddress, String EType, String EBirthdate, Float Salary) {
		Connection database;
		
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO Employee(SSN, EName, ESex, EAddress, EType, EBirthdate, Salary) VALUES(?,?,?,?,?,?,?)");	
			insert.setInt(1, SSN);
			insert.setString(2, EName);
			insert.setString(3, ESex);
			insert.setString(4, EAddress);
			insert.setString(5, EType);
			insert.setString(6, EBirthdate);
			insert.setFloat(7, Salary);
			insert.execute();
			database.close();		
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void removeEmployee(int SSN) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement delete = database.prepareStatement("DELETE FROM Employee WHERE SSN = ?");
			delete.setInt(1, SSN);
			delete.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void viewEmployee() {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("select * from employee");
			ResultSet rs = insert.executeQuery();
			System.out.println("SSN:  NAME:  SEX:  ADDRESS:  TYPE:  BIRTHDATE:  SALARY:");
			while (rs.next()) {
				System.out.println(rs.getObject("SSN") + " " + rs.getObject("EName")+ " " + rs.getObject("ESex") + " " + rs.getObject("EAddress") + " " + rs.getObject("EType") + " " + rs.getObject("EBirthdate") + " " + rs.getObject("Salary"));
			}
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void insertCustomer(int ID, String Name, String Address, String Sex, String Birthdate) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO Customer(ID, Name, Address, Sex, Birthdate) VALUES(?,?,?,?,?)");	
			insert.setInt(1, ID);
			insert.setString(2, Name);
			insert.setString(3, Address);
			insert.setString(4, Sex);
			insert.setString(5, Birthdate);
			insert.execute();
			database.close();		
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void removeCustomer(int ID) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement delete = database.prepareStatement("DELETE FROM Customer WHERE ID = ?");
			delete.setInt(1, ID);
			delete.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void viewCustomer() {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("select*from customer");
			ResultSet rs = insert.executeQuery();
			System.out.println("ID:  NAME:  ADDRESS:  SEX:  BIRTHDATE:");
			while (rs.next()) {
				System.out.println(rs.getObject("ID") + " " + rs.getObject("NAME")+ " " + rs.getObject("ADDRESS") + " " + rs.getObject("SEX") + " " + rs.getObject("BIRTHDATE"));
			}
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void insertCatalogue(int Catalogue_number, int Quantity, int Book_number, String Book) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("INSERT INTO Catalogue(Catalogue_number, Quantity, Book_number, Book) VALUES(?,?,?,?)");
			insert.setInt(1, Catalogue_number);
			insert.setInt(2, Quantity);
                        insert.setInt(3, Book_number);
                        insert.setString(4, Book);
			insert.execute();
			database.close();	
		} 
		catch(Exception e){ 
			System.out.println(e);
		}	
	}
        
        
	
	public void RemoveCatalogue(int Catalogue_Number) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement delete = database.prepareStatement("DELETE FROM Catalogue WHERE Catalogue_number = ?");
			delete.setInt(1, Catalogue_Number);
			delete.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public void ViewCatalogue() {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement insert = database.prepareStatement("select * from catalogue");
			ResultSet rs = insert.executeQuery();
			System.out.println("Catalogue_number:  Quantity:  Book_number: Book:");
			while (rs.next()) {
				System.out.println(rs.getObject("Catalogue_number") + " " + rs.getObject("Quantity")+ " " + rs.getObject("Book_number")+ " " + rs.getObject("Book"));
			}
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
        public void quantityMinus(int book_number) {
		Connection database;
		try {
			database = getConnection();
			PreparedStatement change = database.prepareStatement("update catalogue set Quantity = Quantity - 1 where Book_number = ?");
			change.setInt(1, book_number);
			change.execute();
			database.close();
		} 
		catch(Exception e){ 
			System.out.println(e);
		}
	}
        public void quantityPlus(int book_number, int number){
            Connection database;
            try{
                database = getConnection();
                PreparedStatement change = database.prepareStatement("update catalogue set Quantity = Quantity + ? where Book_number = ?");
                change.setInt(1, number);
                change.setInt(2, book_number);
                change.execute();
		database.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
}

