package connectionToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.Statement;

public class ConnectionFactory {
	private static final Logger LOGGER=Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER= "com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/foodDelivery?serverTimezone=UTC&user=root&password=btsbts43";
	private static final String USER="root";
	private static final String PASS="btsbts43";
	
	private static final ConnectionFactory singleInstance =new ConnectionFactory();
	
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private Connection createConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
		    con = DriverManager.getConnection(DBURL);
		} catch (ClassNotFoundException | SQLException e1) {}
		return con;
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			 con = DriverManager.getConnection(DBURL);
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return con;
	}
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closes(java.sql.Statement pst) {
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
