package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
		
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		
	private static final String USER = "root";
	
	private static final String PASS = "root";

	public static Connection getConnection() {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL_MYSQL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}