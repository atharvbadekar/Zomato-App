package jdbcPractical.MysqlConnection;

public class PizzaHotel {
	int id;
	String dishname;
	double price;
	
	public PizzaHotel() {
		// TODO Auto-generated constructor stub
	}

	public PizzaHotel(int id,String dishname, double price) {
		super();
		this.id = id;
		this.dishname = dishname;
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id : "+id+" Dish Name : "+dishname+" Price : "+price;
	}
	
	
	

}
