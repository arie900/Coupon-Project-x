package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConnectionPool {
	private static ConnectionPool instance = new ConnectionPool();
	private Set<Connection> connections = new HashSet<>();
	private String url = "jdbc:derby://localhost:1527/CouponDB;create=true";

	private ConnectionPool() {
		for (int i = 0; i < 10; i++) {
			try {
				connections.add(DriverManager.getConnection(url));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println(connections);
	}

	public synchronized Iterator<Connection> getConnections() {
		while (connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> iter = connections.iterator();
		iter.next();
		iter.remove();
		System.out.println(connections);

		return iter;

	}

	public synchronized void returnConnection(Connection con) {
		connections.add(con);
		notify();
		System.out.println(connections);

	}

	public void closeAllConnection() {
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ConnectionPool getInstance() {
		return instance;
	}

}
