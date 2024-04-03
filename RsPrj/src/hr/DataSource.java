package hr;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private static String url = "jdbc:oracle:thin:@192.168.116:1523:xe";
	private static String user = "hr";
	private static String password = "hr";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			
			return con;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void closeConnection(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			//nothing
		}
	}
}
