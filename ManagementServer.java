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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ManagementServer {
	
	public int choice;
	public boolean flag;

	//Book Database
	private int Book_Number;
	private String Book_Name; 
	private String Author_Name;
	private double Price;
	private String Date_Published;
	
	//Employee Database
	private int SSN;
	private String EName;	
	private String ESex; 
	private String EAddress;
	private String EType; 
	private String EBirthdate;
	private Float Salary;
	
	//Customer Database
	public int ID; 
	public String Name;
	public String Address;
	public String Sex;
	public String Birthdate;
	
	//Catalogue Database
        private int number;
	private int Catalogue_Number;
	private int Quantity;
        private int Book_number;
        private String Book;
		
		public void Server() {
			Scanner sc = new Scanner(System.in);
			flag = true;

			Print Text = new Print();
			Manager Natas = new Manager();
			
			while(flag) {
				Text.PrintMenu();
				choice = sc.nextInt();
				switch(choice) {
				case 0:
                    flag = false;
					break;
				case 1:
					System.out.println("Insert Book Number");
					Book_Number = sc.nextInt();
					System.out.println("Insert Book Name");
					Book_Name = sc.next();
					System.out.println("Insert Author's Name");
					Author_Name = sc.next();
					System.out.println("Insert Book's Price");
					Price = sc.nextDouble();
					System.out.println("Insert Date Published");
					Date_Published = sc.next();
					Natas.insertBook(Book_Number, Book_Name, Author_Name, Price, Date_Published);
					break;
				case 2:
					System.out.println("Insert Book Number");
					Book_Number = sc.nextInt();
					Natas.removeBook(Book_Number);
					break;
				case 3:
					Natas.viewBook();
					break;
				case 4:
					System.out.println("Insert Employee's SSN");
					SSN = sc.nextInt();
					System.out.println("Insert Employee's Name");
					EName = sc.next();
					System.out.println("Insert Employee's Sex");
					ESex = sc.next();
					System.out.println("Insert Employee's Address");
					EAddress = sc.next();
					System.out.println("Insert Employee Type");
					EType = sc.next();
					System.out.println("Insert Employee's Birthdate");
					EBirthdate = sc.next();
					System.out.println("Insert Employee's Salary");
					Salary = sc.nextFloat();
					Natas.insertEmployee(SSN, EName, ESex, EAddress, EType, EBirthdate, Salary);
					break;
				case 5:
					System.out.println("Insert Employee's SSN");
					SSN = sc.nextInt();
					Natas.removeEmployee(SSN);
					break;
				case 6:
					Natas.viewEmployee();
					break;
				case 7:
					System.out.println("Insert Customer's ID");
					ID = sc.nextInt();
					System.out.println("Insert Customer's Name");
					Name = sc.next();
					System.out.println("Insert Customer's Address");
					Address = sc.next();
					System.out.println("Insert Customer's Sex");
					Sex = sc.next();
					System.out.println("Insert Customer's Birthdate");
					Birthdate = sc.next();
					Natas.insertCustomer(ID, Name, Address, Sex, Birthdate);
					break;
				case 8:
					System.out.println("Insert Customer's ID");
					ID = sc.nextInt();
					Natas.removeCustomer(ID);
					break;
				case 9:
					Natas.viewCustomer();
					break;
				case 10:
					System.out.println("Insert Catalogue's Number");
					Catalogue_Number = sc.nextInt();
					System.out.println("Insert Quantity");
					Quantity = sc.nextInt();
					Natas.insertCatalogue(Catalogue_Number, Quantity, Book_number, Book);
                                        System.out.println("Insert Book Number");
					Book_Number = sc.nextInt();
					break;
				case 11:
					System.out.println("Insert Catalogue's Number");
					Catalogue_Number = sc.nextInt();
					Natas.RemoveCatalogue(Catalogue_Number);
					break;
				case 12:
					Natas.ViewCatalogue();
					break;
                                case 13:
                                        System.out.println("Insert Book's Number");
					Book_Number = sc.nextInt();
					System.out.println("Insert Quantity");
					number = sc.nextInt();
                                        Natas.quantityPlus(Book_Number, number);
                                        break;
				default:
					Text.Valid();
					Text.Pause();
				}
			}
			Text.Exit();
	}
}



