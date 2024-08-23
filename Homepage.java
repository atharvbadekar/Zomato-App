package Zomato;

import java.util.ArrayList;
import java.util.Scanner;

public class Homepage {
	
	static Scanner sc = new Scanner(System.in);
	ArrayList<PizzaHotel> pizza = new ArrayList<PizzaHotel>();
	ArrayList<BurgersHotel> burgers = new ArrayList<BurgersHotel>();
	ArrayList<Cart> cart = new ArrayList<Cart>();
	boolean pizzaInitialization = false;
	boolean burgerInitialization = false;
	
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
		
		if(!pizzaInitialization) {
			pizza.add(new PizzaHotel(1,"Panner Pizza", 200));
			pizza.add(new PizzaHotel(2,"Cheese Pizza", 300));
			pizza.add(new PizzaHotel(3,"Onion Pizza", 150));
			pizza.add(new PizzaHotel(4,"Tomato crush pizza", 149));
			pizza.add(new PizzaHotel(5,"non veg Pizza", 500));
			pizzaInitialization = true;
		}
		
		System.out.println("---------Menu---------");
		for(PizzaHotel p:pizza) {
			System.out.println(p);
		}
		System.out.print("Select dish id : ");
		int dishId = sc.nextInt();
		System.out.print("Enter quantity : ");
		int quantity = sc.nextInt();
		
		for(PizzaHotel p:pizza) {
			if(dishId==p.id) {
				for(int i=0;i<quantity;i++) {
					cart.add(new Cart(p.dishname,p.price,quantity));
					
				}
			}
		}


		orderMore();
	}
	
	public void burgerHotel() {

		if(!burgerInitialization) {
			burgers.add(new BurgersHotel(1,"Veg burger", 150));
			burgers.add(new BurgersHotel(2,"Aloo burger", 100));
			burgers.add(new BurgersHotel(3,"Cheese burger", 200));
			burgers.add(new BurgersHotel(4,"Non Veg burger", 250));
			burgerInitialization = true;
		}
		
		
		System.out.println("---------Menu---------");
		for(BurgersHotel b:burgers) {
			System.out.println(b);
		}
		System.out.print("Select dish id: ");
		int dishId = sc.nextInt();
		System.out.print("Enter quantity : ");
		int quantity = sc.nextInt();
		
		for(BurgersHotel p:burgers) {
			if(dishId==p.id) {
				for(int i=0;i<quantity;i++) {
					cart.add(new Cart(p.dishname,p.price,quantity));
				}
			}
		}
		orderMore();

		
	}
	public void orderMore() {
		System.out.println("Food Added to cart");
		System.out.println("\nWant to order more ? \n");
		System.out.println("1. yes \n2. No");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			{
				chooseHotel();
				break;
			}
		case 2:
			{
				printBill();
				break;
			}
		default:
			{
				printBill();
			}
		}
	}
	
	
	
	
	public void printBill() {
		System.out.println("\nItems in your cart is - \n");
		int bill = 0;
		for(Cart c:cart) {
			System.out.println(c);
			bill+=c.price;
		}
		System.out.println("\nYour Total bill is :- "+bill+" Rs\n");
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
			System.out.println("-----Payment Succesfull------");
			System.out.println("-----Your Order is Processing------");
			break;
		}
		case 2:{
			System.out.println("-----Payment Succesfull------");
			System.out.println("-----Your Order is Processing------");
			break;
		}
		case 3:{
			System.out.println("-----Payment Succesfull------");
			System.out.println("-----Your Order is Processing------");
			break;
		}
		default:{
			System.out.println("Incorrect input");
		}
		}
		System.exit(0);
	}
	
	

}
