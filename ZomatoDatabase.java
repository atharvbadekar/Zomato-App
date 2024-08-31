 package jdbcPractical.MysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ZomatoDatabase {

	String url = "jdbc:mysql://localhost:3306/zomato11";
	String userName = "root";
	String passWord = "password";

	public void createTable(String tablename,String column1,String column2) {

		String query = "create table "+tablename+"("+column1+" varchar(255),"+column2+" varchar(255))";
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			stm.execute(query);
			System.out.println("Table Creation successfull....");
			conn.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	public void createTable(String tablename,String id,String column1,String column2) {

		String query = "create table "+tablename+"(id varchar(255),"+column1+" varchar(255),"+column2+" varchar(255))";
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			stm.execute(query);
			System.out.println("Table Creation successfull....");
			conn.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}


	public void insertdata(String tableName, String username, String password) {

		String query = "INSERT INTO user (username,password) VALUES (?, ?)";

		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();

			System.out.println("Data Insertion successfull....");

			conn.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	public void addToTable(String tablename,int id,String name, double price) {
		String query = "INSERT INTO "+tablename+" (id,dishname,price) VALUES (?,?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);	
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1,id);
			pstm.setString(2, name);
			pstm.setDouble(3, price);
			pstm.execute();

			System.out.println("Item added to cart database");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearCart() {
		String query = "delete from cart";

		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			stm.execute(query);
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void addPizza(String dishname,double price) {
		String query = "INSERT INTO pizzahotel (dishname,price) VALUES (?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
//			
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, dishname);
			pstm.setDouble(2, price);
			pstm.execute();

			System.out.println("Item added to cart database");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addBurger(String dishname,double price) {
		String query = "INSERT INTO burgerhotel (dishname,price) VALUES (?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
//			
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, dishname);
			pstm.setDouble(2, price);
			pstm.execute();

			System.out.println("Item added to cart database");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getdata(String tablename) {
		String query = "select * from "+tablename;
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	public String getNameByid(String tablename,int id) {
		String query = "select * from "+tablename+" where id = "+id;
		String name = null ;
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				name = rs.getString(2);
			}
			
			conn.close();

		} catch (Exception e) {
			System.out.println(e);

		}

		return name;
	}
	public double getPriceByid(String tablename,int id) {
		String query = "select * from "+tablename+" where id = "+id;
		double price=0;
		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				price += rs.getDouble(3);
			}
			
			conn.close();

		} catch (Exception e) {
			System.out.println(e);

		}

		return price;
	}
	public void validatData(String user, String password) {

		String query = "select * from user";

		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
					System.out.println("data Found in databse");
					break;
				}
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	public boolean validateUsername(String user) {

		String query = "select * from user";

		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				if (rs.getString(1).equals(user)) {
					return true;
				}
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);

		}
		return false;

	}

}
