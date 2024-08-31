package jdbcPractical.MysqlConnection;

public class BurgersHotel {

	int id;
	String dishname;
	double price;
	
	public BurgersHotel() {
		// TODO Auto-generated constructor stub
	}

	public BurgersHotel(int id,String dishname, double price) {
		super();
		this.id = id;
		this.dishname = dishname;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: "+id+" Dish Name : "+dishname+" Price : "+price;
	}
}
