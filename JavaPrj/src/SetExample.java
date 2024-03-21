import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SetExample {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<>();
		String s1 = new String("qwertyuio");
		ts.add(s1);
		ts.add("hello");
		ts.add("banana");
		for(String str : ts) {
			System.out.println(str);
		}
		// Tree에 추가되어야 하는 데이터는 비교 가능한 객체여야 함
		// Comparable
		TreeSet<Emp> empSet = new TreeSet<Emp>();
		empSet.add(new Emp("1234","Foo",2900000));
		empSet.add(new Emp("3142","Bar",1500000));
		empSet.add(new Emp("4123","Loo",1000000));
		
		for(Emp emp : empSet) {
			System.out.println(emp);
		}
		
	}
}

@Setter @Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
class Emp implements Comparable<Emp> {
	private String empId;
	private String ename;
	private double salary;
	
	@Override
	public int compareTo(Emp o) {
		//return empId.compareTo(o.empId); // 객체의 정렬하기 위한 방법을 지정
		//return (int)(this.salary - o.salary);
		return ename.compareTo(o.ename);
	}
}
