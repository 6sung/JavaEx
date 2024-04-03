package hr;

import java.util.List;

import hr.emp.EmpDao;
import hr.emp.EmpVo;
import hr.emp.IEmpDao;

public class EmpMain {

	public static void main(String[] args) {
		
		IEmpDao dao = new EmpDao();
//		EmpVo emp = new EmpVo(10,7, null, "AR","CN","F300","KIM02", 0, null, null);
//		
//		dao.insertEmp(emp);
//		System.out.println("고객정보가 입력되었습니다.");
		
//		
		

		//delete
//		dao.deleteEmp(2);
//		try {
//			EmpVo emp = dao.selectEmp(2);
//			System.out.println(emp);
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
		
		// select
		System.out.println("예매 정보를 조회합니다.");
		try {
			EmpVo emp = dao.selectEmp(3);
			System.out.print(emp);
			//System.out.print(emp.getXxxx());
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		// update
//		EmpVo updateEmp = new EmpVo();
//		updateEmp.setResNum(3);
//		updateEmp.setSeatNum(10);
//		dao.updateEmpSalary(updateEmp);
//		try {
//			EmpVo emp = dao.selectEmp(3);
//			System.out.println(emp);
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//
//		List<EmpVo> empList = dao.selectAllEmps();
//		for(EmpVo emp : empList) {
//			System.out.println(emp);
//		}
	}
}
