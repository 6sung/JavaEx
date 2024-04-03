package hr.emp;

import java.util.List;

public interface IEmpDao {
	void insertEmp(EmpVo emp);
	void updateEmpSalary(EmpVo emp);
	void deleteEmp(int resNum);
	EmpVo selectEmp(int resNum);
	List<EmpVo> selectAllEmps();
}
