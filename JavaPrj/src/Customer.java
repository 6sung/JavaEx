import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private String name;
	private char gender;
	private String email;
	private int birthYear;
	
	//constructor
	//setter/getter
	//toString
	//hashCode & Equals
}
// Value Object(VO)
// Data Transfer Object (DTO)
// 값을 갖는 객체를 만들기 위한 클래스
 