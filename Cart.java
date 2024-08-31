package jdbcPractical.MysqlConnection;

public class Cart {
	String dish;
	double price;
	int quantity;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(String dish, double price, int quantity) {
		super();
		this.dish = dish;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dish Name : "+dish+" Price : "+price;
	}

}
