package Zomato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Welcome {
	
	Homepage homepage = new Homepage();
	static Scanner sc = new Scanner(System.in);
	List<User> users = new ArrayList<User>();
	
	public void welcome() {
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
		
		User user = new User(username,password);
		users.add(user);
		System.out.println("Account created");
	}
	
	public void login() {
		sc.nextLine();
		System.out.println("---------Login---------");
		System.out.print("Enter username : ");
		String username = sc.nextLine();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		
		for(User u:users) {
			if(u.username.equals(username) && u.password.equals(password)) {
				System.out.println("Login Successful...");
				homepage.chooseHotel();
				break;
			}
		}
	}
}
