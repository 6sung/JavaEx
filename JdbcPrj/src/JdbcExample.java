import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 클래스가 로드되었습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("데이터베이스 연결을 테스트합니다.");
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe"; 
		String user = "hr"; String password="hr";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			String sql = "select first_name, hire_date, salary, department_id "
					+ "from employees where department_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 60); // 첫번째 ?에 정수 60을 넣는다.
			ResultSet rs = stmt.executeQuery();
			
//			Statement stmt = con.createStatement();
//			String deptno = "\'\' or \' \'=\' \'"; // '' or ' '=' ' -> 조건이 항상 true
//			//String sql = "select employee_id, first_name, salary from employees";
//			String sql = "select first_name, hire_date, salary, department_id "
//					+ "from employees where department_id="+deptno;
//			System.out.println(sql);
//			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
//				System.out.print(rs.getInt("employee_id") + "\t");
//				System.out.print(rs.getString("first_name")+ "\t");
//				System.out.println(rs.getDouble("salary"));
				
				
				System.out.print(rs.getString("first_name")+ "\t");
				System.out.print(rs.getString("hire_date") + "\t");
				System.out.println(rs.getDouble("salary"));
				System.out.print(rs.getInt("department_id") + "\t");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{con.close();}catch(Exception e) {}
		}
		
		
		//Class.forName("oracle.jdbc.OracleDriver");
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//new oracle.jdbc.driver.OracleDriver();
		
		//System.out.println("드라이버 클래스가 로드되었습니다.");
	}

}