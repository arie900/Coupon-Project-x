package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import beans.Company;

public class Test {
	public static void main(String[] args) {
		String url="jdbc:derby://localhost:1527/CouponDB;create=true";
		try (Connection con=DriverManager.getConnection(url);){
			ConnectionPool c1=ConnectionPool.getInstance();
			c1.getConnections();
			c1.returnConnection(con);




			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
