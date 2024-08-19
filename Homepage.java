package Zomato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage {
	
	static Scanner sc = new Scanner(System.in);
	ArrayList<PizzaHotel> pizza = new ArrayList<PizzaHotel>();
	ArrayList<BurgersHotel> burgers = new ArrayList<BurgersHotel>();
	ArrayList<Cart> cart = new ArrayList<Cart>();
	
	public void chooseHotel() {
		System.out.println("--------Hotels-------");
		System.out.println("1. PizzaHotel");
		System.out.println("2. BurgerHotel");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:{
			pizzaHotel();
			break;
		}
		case 2:{
			burgerHotel();
			break;
		}
		default:{
			System.out.println("Incorrect input ");
		}
		}
	}
	
	public void pizzaHotel() {
		
		pizza.add(new PizzaHotel(1,"Panner Pizza", 200));
		pizza.add(new PizzaHotel(2,"Cheese Pizza", 300));
		pizza.add(new PizzaHotel(3,"non veg Pizza", 500));
		
		System.out.println("---------Menu---------");
		for(PizzaHotel p:pizza) {
			System.out.println(p);
		}
		System.out.println("Select dish : ");
		int dishId = sc.nextInt();
		System.out.println("Enter quntity : ");
		int quantity = sc.nextInt();
		
		for(PizzaHotel p:pizza) {
			if(dishId==p.id) {
				for(int i=0;i<quantity;i++) {
					cart.add(new Cart(p.dishname,p.price,quantity));
				}
			}
		}
		System.out.println("Food Added to cart");
		printBill();
	}
	
	public void burgerHotel() {
		burgers.add(new BurgersHotel(1,"Veg burger", 150));
		burgers.add(new BurgersHotel(2,"Cheese burger", 200));
		burgers.add(new BurgersHotel(3,"Non Veg burger", 250));
		
		System.out.println("---------Menu---------");
		for(BurgersHotel b:burgers) {
			System.out.println(b);
		}
		System.out.println("Select dish : ");
		int dishId = sc.nextInt();
		System.out.println("Enter quntity : ");
		int quantity = sc.nextInt();
		
		for(PizzaHotel p:pizza) {
			if(dishId==p.id) {
				for(int i=0;i<quantity;i++) {
					cart.add(new Cart(p.dishname,p.price,quantity));
				}
			}
		}

		System.out.println("Food Added to cart");
		printBill();
		
	}
	
	public void printBill() {
		System.out.println("\nItems in your cart is - \n");
		int bill = 0;
		for(Cart c:cart) {
			System.out.println(c);
			bill+=c.price;
		}
		System.out.println("\nYour Total bill is : "+bill+" Rs\n");
		paymentOption();
	}
	
	public void paymentOption() {
		System.out.println("Enter your payment choice : ");
		System.out.println("1. phonPe");
		System.out.println("2. GPay");
		System.out.println("3. Paytm");
		System.out.print("Enter choice : ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:{
			System.out.println("Your phope Scanner will be generated ");
			System.out.println("\n Payment Succesfull");
			break;
		}
		case 2:{
			System.out.println("Your G-Pay Scanner will be generated ");
			System.out.println("\n Payment Succesfull");
			break;
		}
		case 3:{
			System.out.println("Your PayTM Scanner will be generated ");
			System.out.println("\n Payment Succesfull");
			break;
		}
		default:{
			System.out.println("Incorrect input");
		}
		}
		System.exit(0);
	}
	
	

}
