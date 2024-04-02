import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableExample {
	static {
		try {
			Class.forName("oracle.driver.OracleDriver");
			System.out.println("드라이버가 로드되었습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			String sql = "{call GETSALARY(?,?)}";
			CallableStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, 103);
			stmt.registerOutParameter(2,java.sql.Types.DOUBLE);
			stmt.execute();
			System.out.println(stmt.getDouble(2));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {con.close();}catch(Exception e) {}
		}
	}

}
