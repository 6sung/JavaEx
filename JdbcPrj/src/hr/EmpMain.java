package hr;

import java.util.List;

import hr.emp.EmpDao;
import hr.emp.EmpVo;
import hr.emp.IEmpDao;

public class EmpMain {

	public static void main(String[] args) {
		// UI(CUI) & 제어로직
		
		IEmpDao dao = new EmpDao();
//		EmpVo emp = new EmpVo(300,"JinKyoung","Heo","HEOJK","010",null,"IT_PROG",
//				7000,0, 103, 60);
		
//		dao.insertEmp(emp);
//		System.out.println("고객정보가 입력되었습니다.");
		
		System.out.println("고객의 정보를 조회합니다.");
		try {
			EmpVo emp = dao.selectEmp(300);
			System.out.println(emp);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
//		EmpVo updateEmp = new EmpVo();
//		updateEmp.setEmployeeId(300);
//		updateEmp.setSalary(9000);
//		dao.updateEmpSalary(updateEmp);
//		try {
//			EmpVo emp = dao.selectEmp(300);
//			System.out.println(emp);
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
		
		
//		List<EmpVo> empList = dao.selectAllEmps();
//		for(EmpVo emp : empList) {
//			System.out.println(emp);
//		}

		dao.deleteEmp(300, "HEOJK");
		try {
			EmpVo emp = dao.selectEmp(300);
			System.out.println(emp);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
