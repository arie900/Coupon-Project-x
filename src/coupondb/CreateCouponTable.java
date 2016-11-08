package coupondb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import couponSystemException.CouponSystemException;
public class CreateCouponTable {

		public static void main(String[] args) throws CouponSystemException {
		String driverClassName = "org.apache.derby.jdbc.ClientDriver";
		try {
			// load driver class to memory
			Class.forName(driverClassName);

		} catch (ClassNotFoundException e) {
			String m = "driver was not found";
			throw new CouponSystemException(m);
		}

		// get an enumeration (collection) of all loaded drivers
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		System.out.println("drivers:");

		while (enumeration.hasMoreElements()) {
			Driver driver = enumeration.nextElement();
			System.out.println(driver); // print driver name
		}
		
		// url to the database we want to connect
				String url = "jdbc:derby://localhost:1527/CouponDB;create=true";

				// get a connection object
				
				try (Connection con = DriverManager.getConnection(url);) {

					System.out.println("connected to " + con);

				
				
				
				String coupontable = "CREATE TABLE Coupon (ID BIGINT primary key, TITLE VARCHAR(20), START_DATE DATE, END_DATE DATE, AMOUNT INTEGER, TYPE VARCHAR(20), PRICE DOUBLE, IMAGE VARCHAR(20))";
				String companytable = "CREATE TABLE Company (ID BIGINT, COMP_NAME VARCHAR(20), PASSWORD VARCHAR(20), EMAIL VARCHAR(20), primary key(id))";
				String customertable = "CREATE TABLE Customer (ID BIGINT, CUST_NAME VARCHAR(20), PASSWORD VARCHAR(20), primary key(id))";
				
				PreparedStatement pstmt1 = con.prepareStatement(coupontable);
				pstmt1.executeUpdate();
				System.out.println("success: " + coupontable);
				
				PreparedStatement pstmt2 = con.prepareStatement(companytable);
				pstmt2.executeUpdate();
				System.out.println("success: " + companytable);
				
				PreparedStatement pstmt3 = con.prepareStatement(customertable);
				pstmt3.executeUpdate();
				System.out.println("success: " + customertable);
				
				String company_coupon = "CREATE TABLE Company_Coupon(COMP_ID BIGINT PRIMARY KEY, COUPON_ID BIGINT, FOREIGN KEY(COUPON_ID) REFERENCES Coupon(ID), FOREIGN KEY(COMP_ID) REFERENCES Company(ID))";
				String customer_coupon = "CREATE TABLE Customer_Coupon(CUST_ID BIGINT PRIMARY KEY, COUPON_ID BIGINT,FOREIGN KEY(COUPON_ID) REFERENCES Coupon(ID), FOREIGN KEY(CUST_ID) REFERENCES Customer(ID))";
				
				PreparedStatement pstmt4 = con.prepareStatement(company_coupon);
				pstmt4.executeUpdate();
				System.out.println("success: " + company_coupon);
				
				PreparedStatement pstmt5 = con.prepareStatement(customer_coupon);
				pstmt5.executeUpdate();
				System.out.println("success: " + customer_coupon);
				
	} catch (SQLException e) {
		String m = "server not connected";
		throw new CouponSystemException(m);
	}
				// disconnect
				System.out.println("disconnected");
				
				
			}
		
		
	}


