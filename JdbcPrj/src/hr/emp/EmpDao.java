package hr.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hr.DataSource;

public class EmpDao implements IEmpDao{
	
	@Override
	public void insertEmp(EmpVo emp) {
		Connection con = null;
		try {
			con = DataSource.getConnection();
			String sql = "insert into employees(employee_id, first_name, last_name, email, "
					+ "phone_number, hire_date, job_id, salary, commission_pct, manager_id, "
					+ "department_id) values (?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, emp.getEmployeeId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getPhoneNumber());
			
			stmt.setString(6,emp.getJobId());
			stmt.setDouble(7, emp.getSalary());
			stmt.setDouble(8, emp.getCommissionPct());
			stmt.setInt(9, emp.getManagerId());
			stmt.setInt(10,emp.getDepartmentId());
			stmt.executeUpdate();			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
	}
	
	@Override
	public void updateEmpSalary(EmpVo emp) {
		Connection con = null;
		try {
			con = DataSource.getConnection();
			String sql = "update employees set salary=? where employee_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, emp.getSalary());
			stmt.setInt(2, emp.getEmployeeId());
			stmt.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
	}

	@Override
	public void deleteEmp(int employeeId, String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DataSource.getConnection();
			con.setAutoCommit(false);
			// job_history 테이블 데이터 삭제
			// employees 테이블 데이터 삭제
			String sql1 = "delete from job_history where employee_id=?";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setInt(1, employeeId);
			stmt1.executeUpdate();
			
			String sql2 = "delete from employees where employee_id=? and email=?";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, employeeId);
			stmt2.setString(2, email);
			int deleteCount = stmt2.executeUpdate();
			if(deleteCount == 0) {
				throw new RuntimeException("사원정보가 삭제되지 않았습니다.");
			}
			//다른 사람의 매니저이면 참조 무결성 위배로 예외처리가 실행된다. 따라서 위의 try시작지점에서 autocommit false로 변경한다.
			con.commit();
		}catch(Exception e) {
			try {con.rollback();}catch(Exception e2) {}
			throw new RuntimeException(e);
		}finally {
			try{con.setAutoCommit(true);} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			DataSource.closeConnection(con);
		}
	}

	@Override
	public EmpVo selectEmp(int employeeId) {
		Connection con = null;
		try {
			con = DataSource.getConnection();
			String sql = "select employee_id, first_name, last_name, email, phone_number, "
					+ "hire_date, job_id, salary, commission_pct, manager_id, department_id "
					+ "from employees where employee_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,  employeeId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				//조회한 데이터가 있을 경우
				EmpVo emp = new EmpVo();
				//int empId = rs.getInt("employee_id");
				//emp.setEmployeeId(rs.getInt(empId));
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				return emp;
			}else {
				//조회한 데이터가 없는 경우
				throw new RuntimeException("조회한 사원의 정보가 없습니다.");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
		//return null;
	}

	@Override
	public List<EmpVo> selectAllEmps() {
		Connection con = null;
		List <EmpVo> empList = new ArrayList<>();
		try {
			con = DataSource.getConnection();
			String sql = "select * from employees";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//rs에서 정보를 조회해서 emp 객체에 저장하고 emp객체를 empList에 add()해야함
				EmpVo emp = new EmpVo();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				empList.add(emp);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
		return empList;
	}
}
