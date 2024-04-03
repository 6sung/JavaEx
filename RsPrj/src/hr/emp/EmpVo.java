package hr.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class EmpVo{
	private int resNum;
	private int SeatNum;
	private Date DepartTime;
	private String DepartCon;
	private String ArrCon;
	private String FilId;
	private String Name;
	private int Gate;
	private Double Price1;
	private String CusId;
}