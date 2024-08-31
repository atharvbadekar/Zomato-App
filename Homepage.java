package jdbcPractical.MysqlConnection;

import java.util.Scanner;

public class Homepage {

	static Scanner sc = new Scanner(System.in);

	ZomatoDatabase database = new ZomatoDatabase();
	int cartid = 1;

	public void chooseHotel() {
		System.out.println("--------Hotels-------");
		System.out.println("1. PizzaHotel");
		System.out.println("2. BurgerHotel");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			pizzaHotel();
			break;
		}
		case 2: {
			burgerHotel();
			break;
		}
		default: {
			System.out.println("Incorrect input ");
		}
		}
	}

	public void pizzaHotel() {

		System.out.println("---------Menu---------");

		database.getdata("pizzahotel");
		System.out.print("Select dish : ");
		int dishId = sc.nextInt();
		System.out.print("Enter quntity : ");
		int quantity = sc.nextInt();

		for (int i = 0; i < quantity; i++) {
			String dishname = database.getNameByid("pizzahotel", dishId);
			double price = database.getPriceByid("pizzahotel", dishId);
			database.addToTable("cart", cartid, dishname, price);
			cartid++;
		}

		addMore();
	}

	public void burgerHotel() {

		System.out.println("---------Menu---------");

		database.getdata("burgerhotel");
		System.out.print("Select dish : ");
		int dishId = sc.nextInt();
		System.out.print("Enter quantity : ");
		int quantity = sc.nextInt();

		for (int i = 0; i < quantity; i++) {
			String dishname = database.getNameByid("burgerhotel", dishId);
			double price = database.getPriceByid("burgerhotel", dishId);
			database.addToTable("cart", cartid, dishname, price);
			cartid++;
		}
		addMore();
	}

	public void addMore() {
		System.out.println("Food Added to cart");
		System.out.println("\nWant to order more ? \n");
		System.out.println("1. yes \n2. No");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			chooseHotel();
			break;
		}
		case 2: {
			printBill();
			break;
		}
		default: {
			printBill();
		}
		}
	}

	public void printBill() {

		System.out.println("\nItems in your cart is - \n");
		database.getdata("cart");
		double bill = 0;
		for (int i = cartid; i > 0; i--) {
			double d = database.getPriceByid("cart", i);
			bill += d;
		}
		System.out.println("\nYour Total bill is : " + bill + " Rs\n");
		paymentOption();
	}

	public void paymentOption() {
		System.out.println("Enter your payment choice : ");
		System.out.println("1. phonPe");
		System.out.println("2. GPay");
		System.out.println("3. Paytm");
		System.out.print("Enter choice : ");
		int choice = sc.nextInt();
		if (choice == 1 || choice == 2 || choice == 3) {
			System.out.println("-----Payment Succesfull------");
			System.out.println("-----Your Order is Processing------");
		} else {
			System.out.println("Incorrect Input");
		}
		System.exit(0);
	}

}
