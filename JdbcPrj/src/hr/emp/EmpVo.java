package hr.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class EmpVo {
	// employee_id number(4) -> int employeeId
	// first_name varchar2(20) -> String firstName
	private int employeeId;
	private String FirstName;
	private String LastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
