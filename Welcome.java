package jdbcPractical.MysqlConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Welcome {
	
	Homepage homepage = new Homepage();
	static Scanner sc = new Scanner(System.in);
	ZomatoDatabase database = new ZomatoDatabase();
	
	public void welcome() {
		allSet();
		initializeHotels();
		while(true) {
			System.out.println("\nWelcome to zomato");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1:{
				createAccount();
				break;
			}
			case 2:{
				login();
				break;
			}
			case 3:{
				System.exit(0);
			}
			default:{
				System.out.println("Incorrect Input ");
			}
			}
		}
	}
	
	public void createAccount() {
		sc.nextLine();
		System.out.println("------create account------");
		System.out.print("Enter username : ");
		String username = sc.nextLine();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		
		if(!database.validateUsername(username)) {
			database.insertdata("user", username, password);
			System.out.println("Account created");
		}
		else {
			System.out.println("Username already exist");
			System.out.println("Try with different username");
		}
	}
	
	public void login() {
		sc.nextLine();
		System.out.println("---------Login---------");
		System.out.print("Enter username : ");
		String username = sc.nextLine();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
	
		database.validatData(username, password);
		homepage.chooseHotel();
	}
	public void allSet() {
		database.createTable("user","username","password");
		database.createTable("pizzahotel","id","dishname","price");
		database.createTable("burgerhotel","id","dishname","price");
		database.createTable("cart","id","dishname","price");
		
	}
	public void initializeHotels() {
		
		database.clearCart();

		database.addToTable("pizzahotel",1,"Panner Pizza", 200);
		database.addToTable("pizzahotel",2,"Cheese Pizza", 300);
		database.addToTable("pizzahotel",3,"Onion Pizza", 150);
		database.addToTable("pizzahotel",4,"Tomato crush pizza", 149);
		database.addToTable("pizzahotel",5,"non veg Pizza", 500);
		
		database.addToTable("burgerhotel",1,"Veg burger", 150);
		database.addToTable("burgerhotel",2,"Aloo burger", 100);
		database.addToTable("burgerhotel",3,"Cheese burger", 200);
		database.addToTable("burgerhotel",4,"Non Veg burger", 250);
		
	}
}
