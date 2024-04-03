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
			String sql = "insert into reservation(res_num, seat_num, depart_time, depart_con, arr_con, "
					+ "cus_id, fli_id) values (?, ?, sysdate, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, emp.getResNum());
			stmt.setInt(2, emp.getSeatNum());
			stmt.setString(3, emp.getDepartCon());
			stmt.setString(4, emp.getArrCon());
			stmt.setString(5,emp.getCusId());
			stmt.setString(6, emp.getFilId());
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
			String sql = "update reservation set seat_num=? where res_num=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, emp.getSeatNum());
			stmt.setInt(2, emp.getResNum());
			stmt.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
		
	}

	@Override
	public void deleteEmp(int resNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DataSource.getConnection();
			con.setAutoCommit(false);
			String sql1 = "delete from reservation where res_num=?";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setInt(1, resNum);
			stmt1.executeUpdate();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
	}

	@Override
	public EmpVo selectEmp(int resNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DataSource.getConnection();
			String sql = "SELECT r.res_num, r.seat_num, r.depart_time, o1.con_name as depart, o2.con_name as arr, c.name, r.fli_id, f.gate,o1.price_code as price1 ,o2.price_code as price2 "
					+ "FROM reservation r JOIN country o1 ON o1.con_id = r.depart_con JOIN country o2 ON o2.con_id = r.arr_con JOIN customer c ON c.cus_id = r.cus_id JOIN flight f ON f.fli_id = r.fli_id "
					+ "WHERE r.res_num = ?";
			
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,  resNum);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				EmpVo emp = new EmpVo();
				emp.setResNum(rs.getInt("res_num"));
				emp.setSeatNum(rs.getInt("seat_num"));
				emp.setDepartTime(rs.getDate("depart_time"));
				emp.setDepartCon(rs.getString("depart"));
				emp.setArrCon(rs.getString("arr"));
				emp.setName(rs.getString("name"));
				emp.setFilId(rs.getString("fli_id"));
				emp.setGate(rs.getInt("gate"));
				emp.setPrice1(Math.ceil(rs.getDouble("price1") * rs.getDouble("price2") * 100000));
				return emp;
			}else {
				throw new RuntimeException("조회한 고객의 정보가 없습니다.");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			DataSource.closeConnection(con);
		}
	}

	@Override
	public List<EmpVo> selectAllEmps() {
		// TODO Auto-generated method stub
		Connection con = null;
		List <EmpVo> empList = new ArrayList<>();
		try {
			con = DataSource.getConnection();
			String sql = "select * from reservation";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmpVo emp = new EmpVo();
				emp.setResNum(rs.getInt("res_num"));
				emp.setSeatNum(rs.getInt("seat_num"));
				emp.setDepartTime(rs.getDate("depart_time"));
				emp.setDepartCon(rs.getString("depart_con"));
				emp.setArrCon(rs.getString("arr_con"));
				//emp.setCusId(rs.getString("cus_id"));
				emp.setFilId(rs.getString("fli_id"));
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
